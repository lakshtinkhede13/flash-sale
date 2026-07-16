package flash_sale.salee.inventory;

import flash_sale.salee.DtOINventory.register;
import flash_sale.salee.DtOINventory.Response;
import flash_sale.salee.Exceptionhandler.productnotfound;
import flash_sale.salee.product.Product;
import flash_sale.salee.product.Productrepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class invenoryservice {
    private final Inventoryrepo inventoryrepo;
    private final Productrepo productrepo;


    public Response request(register register){


        Product product = productrepo.findById(register.getPid())
                .orElseThrow((()-> new productnotfound("user not found")));





        Inventory inventory = Inventory.builder()


                .totalstock(register.getTotalstock())
                .avilable(register.getTotalstock())
                .reseverd(0)
                .product(product)
                .sold(0)
                .build();

        inventoryrepo.save(inventory);

        //resomse

        Response response = Response.builder()
                .name(inventory.getName())
                .pid(inventory.getProduct().getPid())
                .category(inventory.getCategory())
                .totalstock(inventory.getTotalstock())
                .avilable(inventory.getAvilable())
                .build();

        return response;

    }
    //get bana lete ab bas

    public List<Response> getall(){
       List<Inventory>inventories=inventoryrepo.findAll();
       List<Response>responses = new ArrayList<>();

       for ( Inventory inventory :inventories){
           Response response = Response.builder()
                   .sold(inventory.getSold())

                   .name(inventory.getName())
                   .pid(inventory.getPid())
                   .reseverd(inventory.getReseverd())
                   .category(inventory.getCategory())
                   .sold(inventory.getSold())
                   .build();

       }

       return responses;
    }

}
