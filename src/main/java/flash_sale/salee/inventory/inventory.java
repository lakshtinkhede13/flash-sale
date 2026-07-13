package flash_sale.salee.inventory;

import flash_sale.salee.product.product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class inventory {
    @Id
    private long productid;
    private String name;
    private String category;
    private int totalstock;
    private int avilable;
    private int reseverd;
    private int sold;

    @OneToOne(mappedBy="inventory")
    private product product;

}
