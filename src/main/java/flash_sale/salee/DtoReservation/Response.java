package flash_sale.salee.DtoReservation;

import flash_sale.salee.Reservation.status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Response {


    private Long pid;
    private Long id;
    private int quantity;
    private status status;
}
