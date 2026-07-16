package flash_sale.salee.Paymentdto;

import flash_sale.salee.payment.paymentstatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Responsepayment {

    private Long payemntid;
    private Long userid;
    private Long productid;
    private String productname;
    private  String productcatergory;
    private Double amount;
    private paymentstatus paymentstatus;
    private LocalDateTime Iime;

}
