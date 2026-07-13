package flash_sale.salee.payment;
import org.springframework.stereotype.Service;

@Service
public class paymentserrvice {
    private final Paymentrepo paymentrepo;

    public paymentserrvice(Paymentrepo paymentrepo) {
        this.paymentrepo = paymentrepo;
    }
}
