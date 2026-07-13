package flash_sale.salee.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sellerrepo extends JpaRepository<sellerprofile,Long> {
    boolean existsByGstnumber(String gstnumber);
}
