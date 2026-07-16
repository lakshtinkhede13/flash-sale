package flash_sale.salee.product;

import flash_sale.salee.seller.sellerprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository<Product,Long> {

    boolean existsByProductnameAndSellerprofile(
            String productname,
            sellerprofile sellerprofile
    );
}
