package flash_sale.salee.payment;

import flash_sale.salee.Paymentdto.Requestpayment;
import flash_sale.salee.Paymentdto.Responsepayment;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class paymentcontroller {

    private final paymentserrvice paymentserrvice;

    @PostMapping("/register")
    public Responsepayment responsepayment(@Valid @RequestBody Requestpayment requestpayment){

        return paymentserrvice.responsepayment(requestpayment);
    }

}
