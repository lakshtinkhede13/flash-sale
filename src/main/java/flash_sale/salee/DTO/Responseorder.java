package flash_sale.salee.DTO;

import flash_sale.salee.order.orderstatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Responseorder {
    private Long orderid;
    private Long userid;
    private Long productid;
    private Long paymentid;
    private String productname;
    private int quantity;
    private Double amount;
    private orderstatus orderstatus;
    private LocalDateTime ordertime;
}

