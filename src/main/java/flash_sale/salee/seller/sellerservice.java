package flash_sale.salee.seller;
import org.springframework.stereotype.Service;

@Service
public class sellerservice {

    private final Sellerrepo sellerrepo;

    public sellerservice(Sellerrepo sellerrepo) {
        this.sellerrepo = sellerrepo;
    }
}
