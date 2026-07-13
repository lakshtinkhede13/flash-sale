package flash_sale.salee.order;
import org.springframework.stereotype.Service;

@Service
public class orderservice {
    private final Orderrepo orderrepo;

    public orderservice(Orderrepo orderrepo) {
        this.orderrepo = orderrepo;
    }
}
