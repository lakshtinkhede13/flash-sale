package flash_sale.salee.order;

import flash_sale.salee.payment.payment;
import flash_sale.salee.reservation.reservation;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
@Data
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userid")
    private Users users;



    private double totalamount;

    private LocalDateTime orderat;

        @Enumerated(EnumType.STRING)
    private orderstatus orderstatus;

        @OneToOne
        @JoinColumn(name = "payment_id")
    private payment payment;

    @OneToOne
    @JoinColumn(name="reservation_id")
    private reservation reservation;


}


