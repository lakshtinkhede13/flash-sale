package flash_sale.salee.Exceptionhandler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorRzesponse {



    private LocalDateTime errortime;
    private String mesgg;
    private String error;
    private int status;
}
