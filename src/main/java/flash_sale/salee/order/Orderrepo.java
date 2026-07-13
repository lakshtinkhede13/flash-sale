package flash_sale.salee.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orderrepo extends JpaRepository<order,Long> {
}
