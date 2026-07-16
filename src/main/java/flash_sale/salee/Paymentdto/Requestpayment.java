package flash_sale.salee.Paymentdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Requestpayment {
    @NotBlank
    private Long userid;
    @NotBlank
    private Long productid;
    @Positive
    private Double amount;
    @NotBlank
    private String method;

}
