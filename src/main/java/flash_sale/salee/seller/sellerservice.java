package flash_sale.salee.seller;
import flash_sale.salee.DTO.UserResponse;
import flash_sale.salee.seller_dto.Registerseller;
import flash_sale.salee.seller_dto.Responseseller;
import flash_sale.salee.user.Userrepository;
import flash_sale.salee.user.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class sellerservice {

    private final Sellerrepo sellerrepo;
    public final Userrepository userrepository;

    public sellerservice(Sellerrepo sellerrepo, Userrepository userrepository) {

        this.sellerrepo = sellerrepo;
        this.userrepository = userrepository;
    }

    public Responseseller responseseller(Registerseller registerseller ){



        if (sellerrepo.existsByGstnumber(registerseller.getGstnumber())){
           throw new RuntimeException("gst number is allocated use different");
       }


        Users users = userrepository.findById(registerseller.getId())
                .orElseThrow(()-> new RuntimeException("user not found"));


                sellerprofile seller = new sellerprofile();

                seller.setShopname(registerseller.getShopname());
                seller.setGstnumber(registerseller.getGstnumber());

                seller.setUsers(users);

                seller.setVerfied(false);

                sellerrepo.save(seller);
            // response banega
        Responseseller responseseller = new Responseseller();

        responseseller.setId(seller.getId());

        responseseller.setShopname(seller.getShopname());
        responseseller.setGstnumber(seller.getGstnumber());
        responseseller.setVerifed(seller.isVerfied());



        return  responseseller;




    }
    public List<Responseseller>getall(){
        List<sellerprofile>sellerprofiles = sellerrepo.findAll();

        List<Responseseller> response = new ArrayList<>();

        for (sellerprofile sellerprofile : sellerprofiles){

            Responseseller responseseller = new Responseseller();

            responseseller.setShopname(sellerprofile.getShopname());

            responseseller.setUserId(sellerprofile.getId());

            responseseller.setGstnumber(sellerprofile.getGstnumber());

            responseseller.setVerifed(sellerprofile.isVerfied());

            response.add(responseseller);
        }

        return response;
    }
    public Responseseller responseseller( Long id ,Registerseller registerseller){
       Responseseller responseseller = new Responseseller();
       sellerprofile sellerprofile = sellerrepo.findById(id).
               orElseThrow(()->new RuntimeException("user not found"));
               sellerprofile.setShopname(responseseller.getShopname());
               sellerprofile.setGstnumber(registerseller.getGstnumber());

               sellerrepo.save(sellerprofile);

               return  responseseller;
    }
    public String delete(Long id){
        sellerprofile sellerprofile = sellerrepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        sellerrepo.deleteById(id);
        return "seller deleted";

    }
}
