package flash_sale.salee.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reservationrepo extends JpaRepository<reservation,Long> {
}