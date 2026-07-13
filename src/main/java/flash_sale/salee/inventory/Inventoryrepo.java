package flash_sale.salee.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inventoryrepo extends JpaRepository<inventory,Long > {

}
