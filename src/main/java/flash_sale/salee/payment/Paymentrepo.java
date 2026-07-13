package flash_sale.salee.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paymentrepo extends JpaRepository<payment,Long> {
}
