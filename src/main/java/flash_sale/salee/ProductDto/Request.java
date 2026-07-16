package flash_sale.salee.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private long selllerid;
    private long productid;
    private String productname;
    private String category;
    private Double price;

}
