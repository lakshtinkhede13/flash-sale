package flash_sale.salee.product;
import flash_sale.salee.Exceptionhandler.productnotfound;
import flash_sale.salee.Exceptionhandler.sellernotfound;
import flash_sale.salee.ProductDto.Register;
import flash_sale.salee.ProductDto.Request;
import flash_sale.salee.seller.Sellerrepo;
import flash_sale.salee.seller.sellerprofile;
import flash_sale.salee.user.Userrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class productservice {
    private final Productrepo productrepo;
    private final Sellerrepo sellerrepo;


    public Request response(Register register){




        sellerprofile sellerprofile = sellerrepo.findById(register.getSellerId())
                .orElseThrow((()-> new sellernotfound("seller not found")));

        if (productrepo.existsByProductnameAndSellerprofile(register.getProductname(),sellerprofile)){
            throw new productnotfound("seller with this  not product exist");
        }

        Product product = Product.builder()
                .productname(register.getProductname())
                .category(register.getCategory())
                .price(register.getPrice())
                .sellerprofile(sellerprofile)

                .build();

        productrepo.save(product);


        //abresponse banaeyege

        Request request = Request.builder()
                .productname(product.getProductname())
                .price(product.getPrice())
                .productid(product.getPid())
                .selllerid(register.getSellerId())
                .category(product.getCategory())



                .build();

        return request;


    }

    public List<Request> getallproduct(){
        List<Product> products = productrepo.findAll();
        List<Request> request = new ArrayList<>();
        for (Product product : products){

            Request request1 = Request.builder()
                    .productname(product.getProductname())
                    .price(product.getPrice())
                    .category(product.getCategory())
                    .productid(product.getPid())
                    .selllerid(product.getSellerprofile().getId())
                    .build();

            request.add(request1);

        }
        return request;

    }

    public Request response(Long pid, Register register){



        Product product = productrepo.findById(pid).orElseThrow(()->new RuntimeException("cant find product"));


        product.setProductname(register.getProductname());
        product.setCategory(register.getCategory());
        product.setPrice(register.getPrice());



        Request request = Request.builder()
                .productname(register.getProductname())
                .category(register.getCategory())
                .build();

        productrepo.save(product);

        return request;

        }

        public String delete(Long pid){
            Product product = productrepo.findById(pid).orElseThrow(()->new RuntimeException("cant find product"));

            productrepo.delete(product);

            return "product deleted succefully";

        }


}
