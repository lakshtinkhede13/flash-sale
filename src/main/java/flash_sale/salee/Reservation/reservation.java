package flash_sale.salee.Reservation;

import flash_sale.salee.product.Product;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rid;

        private int quantity;

        private LocalDateTime resevationtime;
        private LocalDateTime expirytime;

        @Enumerated(EnumType.STRING)
        private status status;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private Users users;

}
