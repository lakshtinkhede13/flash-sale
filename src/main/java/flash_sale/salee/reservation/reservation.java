package flash_sale.salee.reservation;

import flash_sale.salee.product.product;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
public class reservation {
    @Id
    private long id;

        private int quantiyty;

        private LocalDateTime resevationtime;
        private LocalDateTime expirytime;

        @Enumerated(EnumType.STRING)
        private status status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

}
