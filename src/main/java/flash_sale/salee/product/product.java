package flash_sale.salee.product;

import flash_sale.salee.inventory.inventory;
import flash_sale.salee.reservation.reservation;
import flash_sale.salee.seller.sellerprofile;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Productid;
    private String name;

    private String price;
    private String category;
    private LocalDateTime salestarttime;
    private LocalDateTime salesendtime;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private sellerprofile sellerprofile;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private inventory inventory;

    @OneToMany(mappedBy = "product")
    private List<reservation> reservations;



}
