package flash_sale.salee.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<Users,Long> {
    boolean existsByemail(String email);
}
