package flash_sale.salee.DtOINventory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data

public class register {
    @NotBlank
    private Long pid;
    @Positive
    private int totalstock;
}
