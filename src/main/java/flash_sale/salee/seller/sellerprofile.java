package flash_sale.salee.seller;

import flash_sale.salee.product.Product;
import flash_sale.salee.user.Users;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;


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
    @JsonIgnore
    @OneToMany(mappedBy = "sellerprofile")
    private List<Product> Products;

    @OneToOne

            @JoinColumn(name = "app_users")
    @ToString.Exclude
    private Users users;

}
