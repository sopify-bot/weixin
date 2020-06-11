package pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pay.entity.Price;

import java.util.List;
import java.util.Optional;

@Component
public interface PriceRepository extends JpaRepository<Price,Long> {

    public List<Price> findAllByPriceId(String priceId);

}
