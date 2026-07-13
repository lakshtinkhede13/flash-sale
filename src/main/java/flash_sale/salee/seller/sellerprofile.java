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




    private int number;
   //    private String gst;
    private boolean verfied;
    private String shopname;
    private String gstnumber;

    private LocalDateTime createdat;

    @OneToMany(mappedBy = "sellerprofile")
    private List<product> products;

    @OneToOne
            @JoinColumn(name = "app_users")
    private Users users;

}
