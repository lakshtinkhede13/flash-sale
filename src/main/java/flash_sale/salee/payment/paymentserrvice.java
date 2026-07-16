package flash_sale.salee.payment;
import flash_sale.salee.Exceptionhandler.productnotfound;
import flash_sale.salee.Exceptionhandler.usernotfound;
import flash_sale.salee.Paymentdto.Requestpayment;
import flash_sale.salee.Paymentdto.Responsepayment;
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

public class paymentserrvice {
    private final Paymentrepo paymentrepo;
    private final Userrepository userrepository;
    private final Productrepo productrepo;
    @Transactional
    public Responsepayment responsepayment(Requestpayment requestpayment){




        System.out.println(requestpayment);
        System.out.println("User ID = " + requestpayment.getUserid());
        System.out.println("Product ID = " + requestpayment.getProductid());
        System.out.println("Amount = " + requestpayment.getAmount());
        System.out.println("Method = " + requestpayment.getMethod());

        Users users = userrepository.findById(requestpayment.getUserid())
              .orElseThrow(()-> new usernotfound("user not found"));

       Product product = productrepo.findById(requestpayment.getProductid())
        .orElseThrow(()-> new productnotfound("product not found"));

        payment payment = flash_sale.salee.payment.payment.builder()


                .amount(requestpayment.getAmount())
                .TIme(LocalDateTime.now())
                .paymentstatus(paymentstatus.SUCEFULLY)
                .product(product)
                .users(users)
                .build();

        paymentrepo.save(payment);

        Responsepayment responsepayment = Responsepayment.builder()
                .payemntid(payment.getPaymentid())
                .userid(users.getId())
                .productname(product.getProductname())
                .productid(requestpayment.getProductid())
                .amount(product.getPrice())
                .paymentstatus(flash_sale.salee.payment.paymentstatus.SUCEFULLY)
                .Iime(payment.getTIme())

                .build();


        return responsepayment;
    }




}



