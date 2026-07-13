package flash_sale.salee.payment;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
@Entity
@Data

public class payment {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long paymentid;
    private String method;
    private double price;
    private LocalDateTime paymentinitialize;

    @Enumerated(EnumType.STRING)
    private paymentstatus paymentstatus;

}
