package flash_sale.salee.user;

import flash_sale.salee.Reservation.reservation;
import flash_sale.salee.payment.payment;
import flash_sale.salee.seller.sellerprofile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "app_users")


public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerid;
    private String username;
    private String password;
    private String email;

    private LocalDateTime createdat;
    private Long number;

    @Enumerated(EnumType.STRING)
    private role Role;

    @OneToOne(mappedBy = "users")
    @ToString.Exclude
    private sellerprofile sellerprofile;


    @OneToMany(mappedBy = "users")
    private List<reservation>reservations;

    @OneToMany(mappedBy = "users")
    @ToString.Exclude
    private List<payment> payments;
}
