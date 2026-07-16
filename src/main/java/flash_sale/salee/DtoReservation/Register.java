package flash_sale.salee.DtoReservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Register {

        @NotBlank
        private Long pid;
        @NotBlank
        private Long id;
        @Positive
        private int quantity;

}
