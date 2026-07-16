package flash_sale.salee.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {

    @NotBlank
    private String username;
    @NonNull
    private String password;
    @Email
    private String email;
    @Positive
    private Long number;


}
