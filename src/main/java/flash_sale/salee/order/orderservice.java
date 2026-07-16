package flash_sale.salee.order;
import flash_sale.salee.DTO.Requestorder;
import flash_sale.salee.DTO.Responseorder;
import flash_sale.salee.Exceptionhandler.paymentnotfound;
import flash_sale.salee.Exceptionhandler.productnotfound;
import flash_sale.salee.Exceptionhandler.usernotfound;
import flash_sale.salee.inventory.Inventory;
import flash_sale.salee.inventory.Inventoryrepo;
import flash_sale.salee.payment.Paymentrepo;
import flash_sale.salee.payment.payment;
import flash_sale.salee.product.Product;
import flash_sale.salee.product.Productrepo;
import flash_sale.salee.user.Userrepository;
import flash_sale.salee.user.Users;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor



public class orderservice {
    private final Orderrepo orderrepo;
    private final Userrepository userrepository;
    private final Productrepo productrepo;
    private final Paymentrepo paymentrepo;
    private  final Inventoryrepo inventoryrepo;

    @Transactional
    public Responseorder responseorder(Requestorder requestorder){

        payment payment = paymentrepo.findById(requestorder.getPaymentid())
                .orElseThrow(()-> new paymentnotfound("payment id not found"));



        Product product = productrepo.findById(requestorder.getProductid())
                .orElseThrow(() -> new productnotfound("Product not found"));

        Users users = userrepository.findById(requestorder.getUserid())
                .orElseThrow(() -> new usernotfound("User not found"));



        Inventory inventory = inventoryrepo.findByproduct(product);

        if (inventory == null) {
            throw new RuntimeException("Inventory not found");
        }

        if (inventory.getAvilable() < requestorder.getQuantiy()) {
            throw new RuntimeException("Not enough stock available");
        }


        inventory.setAvilable(inventory.getAvilable() - requestorder.getQuantiy()
        );

        inventory.setSold(inventory.getSold() + requestorder.getQuantiy()
        );

        inventoryrepo.save(inventory);


        Order order = Order.builder()
                .quantiy(requestorder.getQuantiy())

                .orderstatus(orderstatus.CONFIRM)
                .payment(payment)
                .orderat(LocalDateTime.now())
                .users(users)
                .build();

        orderrepo.save(order);

        // Response
        Responseorder response = Responseorder.builder()
                .orderid(order.getOrderid())
                .userid(users.getId())
                .productid(product.getPid())
                .paymentid(payment.getPaymentid())
                .quantity(requestorder.getQuantiy())
                .orderstatus(orderstatus.CONFIRM)
                .ordertime(order.getOrderat())
                .build();

        return response;

    }


}
