package flash_sale.salee.payment;

import flash_sale.salee.product.Product;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class payment {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long paymentid;
    private String method;
    private double amount;
    private LocalDateTime TIme;

    @Enumerated(EnumType.STRING)
    private paymentstatus paymentstatus;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
