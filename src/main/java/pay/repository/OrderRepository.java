package pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pay.entity.Order;

import java.util.Optional;

@Component
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findFirstById(Long id);
}
