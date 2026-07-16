package flash_sale.salee.inventory;

import flash_sale.salee.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inventoryrepo extends JpaRepository<Inventory,Long > {
    Inventory findByproduct(Product product);
}
