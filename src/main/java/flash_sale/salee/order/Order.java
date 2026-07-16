package flash_sale.salee.order;

import flash_sale.salee.payment.payment;
import flash_sale.salee.Reservation.reservation;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    @ManyToOne
    @JoinColumn(name = "userid")
    private Users users;

    private int quantiy;



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


