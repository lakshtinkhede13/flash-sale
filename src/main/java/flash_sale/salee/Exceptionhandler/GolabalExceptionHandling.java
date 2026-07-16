package flash_sale.salee.Exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GolabalExceptionHandling {

    @ExceptionHandler(sellernotfound.class)
    public ResponseEntity<ErrorRzesponse> handleusellerserexception(sellernotfound ex) {
        ErrorRzesponse errorRzesponse = ErrorRzesponse.builder()
                .error("sellerusernt found")
                .mesgg(ex.getMessage())
                .status(420)
                .errortime(LocalDateTime.now())


                .build();

        return new ResponseEntity<>(errorRzesponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(usernotfound.class)
    public ResponseEntity<ErrorRzesponse> handleusellerserexception(usernotfound ux) {
        ErrorRzesponse errorRzesponse = ErrorRzesponse.builder()
                .error("usernt found")
                .mesgg(ux.getMessage())
                .status(420)
                .errortime(LocalDateTime.now())


                .build();

        return new ResponseEntity<>(errorRzesponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(productnotfound.class)
    public ResponseEntity<ErrorRzesponse> handleproductexception(productnotfound ux) {
        ErrorRzesponse errorRzesponse = ErrorRzesponse.builder()
                .error("product not found")
                .mesgg(ux.getMessage())
                .status(420)
                .errortime(LocalDateTime.now())


                .build();

        return new ResponseEntity<>(errorRzesponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(paymentnotfound.class)
    public ResponseEntity<ErrorRzesponse> handleproductexception(paymentnotfound ux) {
        ErrorRzesponse errorRzesponse = ErrorRzesponse.builder()
                .error("payment not found")
                .mesgg(ux.getMessage())
                .status(420)
                .errortime(LocalDateTime.now())


                .build();

        return new ResponseEntity<>(errorRzesponse, HttpStatus.NOT_FOUND);
    }
}
