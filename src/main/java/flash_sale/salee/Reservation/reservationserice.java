package flash_sale.salee.Reservation;
import flash_sale.salee.DtoReservation.Register;
import flash_sale.salee.DtoReservation.Response;
import flash_sale.salee.inventory.Inventory;
import flash_sale.salee.inventory.Inventoryrepo;
import flash_sale.salee.product.Product;
import flash_sale.salee.product.Productrepo;
import flash_sale.salee.user.Userrepository;
import flash_sale.salee.user.Users;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor

public class reservationserice {

    private final Reservationrepo reservationrepo;
    private final Userrepository userrepository;
    private final Productrepo productrepo;
    private final Inventoryrepo inventoryrepo;

    @Transactional
    public Response response(Register register){



   ;


        Product product = productrepo.findById(register.getPid())
                .orElseThrow(()-> new RuntimeException("product not found"));





        Users users = userrepository.findById(register.getId())
                .orElseThrow(()-> new RuntimeException("product not found"));


        reservation reservation = flash_sale.salee.Reservation.reservation.builder()
                .quantity(register.getQuantity())
                .status(status.ACTIVE)
                .resevationtime(LocalDateTime.now())
                .expirytime(LocalDateTime.now().plusMinutes(10))
                .users(users)
                .product(product)
                .build();




        reservationrepo.save(reservation);

        //response banayege

        Response response = Response.builder()
                .pid(register.getPid())
                .id(register.getId())
                .quantity(register.getQuantity())
                .status(reservation.getStatus())

                .build();


        return response;

    }


}
