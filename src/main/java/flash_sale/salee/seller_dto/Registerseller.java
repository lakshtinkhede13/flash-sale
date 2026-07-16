package flash_sale.salee.seller_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

      @Data
    public class Registerseller {

    private Long id;
    @NotBlank
    private String shopname;
    @NotBlank
    private String gstnumber;



}
