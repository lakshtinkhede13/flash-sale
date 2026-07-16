package flash_sale.salee.product;

import flash_sale.salee.inventory.Inventory;
import flash_sale.salee.Reservation.reservation;
import flash_sale.salee.seller.sellerprofile;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String productname;

    private Double price;
    private String category;
    private LocalDateTime salestarttime;
    private LocalDateTime salesendtime;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @ToString.Exclude
    private sellerprofile sellerprofile;

    @OneToOne(mappedBy = "product")
    @ToString.Exclude
    private Inventory inventory;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<reservation> reservations;



}
