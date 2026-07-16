package flash_sale.salee.inventory;

import flash_sale.salee.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    private String name;
    private String category;
    private int totalstock;
    private int avilable;
    private int reseverd;
    private int sold;

    @OneToOne
    @JoinColumn(name = "productid")
    @ToString.Exclude
    private Product product;


}
