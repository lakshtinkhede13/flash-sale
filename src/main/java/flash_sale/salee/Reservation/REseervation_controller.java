package flash_sale.salee.Reservation;

import flash_sale.salee.DtoReservation.Register;
import flash_sale.salee.DtoReservation.Response;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
@AllArgsConstructor
public class REseervation_controller {

    private final reservationserice reservationserice;


    //post method

    @PostMapping("/register")
    public Response response( @RequestBody Register register){
        return reservationserice.response(register);
    }



}
