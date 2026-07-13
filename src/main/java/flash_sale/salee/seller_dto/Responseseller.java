package flash_sale.salee.seller_dto;

import lombok.Data;

@Data
public class Responseseller {


    private Long id;
    private Long userId;
    private String shopname;
    private String gstnumber;
    private boolean verifed;
}
