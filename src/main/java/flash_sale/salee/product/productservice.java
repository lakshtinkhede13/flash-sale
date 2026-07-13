package flash_sale.salee.product;
import org.springframework.stereotype.Service;

@Service
public class productservice {
    private final Productrepo productrepo;

    public productservice(Productrepo productrepo) {
        this.productrepo = productrepo;
    }
}
