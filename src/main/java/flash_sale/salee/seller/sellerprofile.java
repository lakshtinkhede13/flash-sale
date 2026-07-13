package flash_sale.salee.seller;

import flash_sale.salee.product.product;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sellerprofile")
@Data
public class sellerprofile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sellerid;



    private LocalDateTime createdat;
    private int number;
    private int gst;
    private boolean verfied;

    @OneToMany(mappedBy = "sellerprofile")
    private List<product> products;

    @OneToOne
            @JoinColumn(name = "app_users")
    private Users users;

}
