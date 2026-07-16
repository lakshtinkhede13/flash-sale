package flash_sale.salee.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Data
public class Requestorder {
    @NonNull
    private Long userid;
    @NonNull
    private Long productid;
    @NotBlank
    private Long paymentid;
    @Positive
    private int quantiy;

}
