package flash_sale.salee.reservation;
import org.springframework.stereotype.Service;

@Service
public class reservationserice {

    private final Reservationrepo reservationrepo;

    public reservationserice(Reservationrepo reservationrepo) {
        this.reservationrepo = reservationrepo;
    }
}
