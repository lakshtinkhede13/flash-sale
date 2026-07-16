package flash_sale.salee.DtOINventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class Response {

    private Long pid;
    private String name;
    private String category;
    private int totalstock;
    private int avilable;
    private int reseverd;
    private int sold;
}
