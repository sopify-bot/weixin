package pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pay.entity.Product;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByProId(String proId);

}
