package flash_sale.salee.ProductDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Register {

    private long sellerId;
    @NotBlank
    private String productname;
    @NotBlank
    private String category;
    @Positive

    private Double price;



}
