package flash_sale.salee.user;

import flash_sale.salee.reservation.reservation;
import flash_sale.salee.seller.sellerprofile;
import jakarta.persistence.*;
import lombok.Data;


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
    private int number;

    @Enumerated(EnumType.STRING)
    private role Role;

    @OneToOne(mappedBy = "users")
    private sellerprofile sellerprofile;


    @OneToMany(mappedBy = "users")
    private List<reservation>reservations;

}
