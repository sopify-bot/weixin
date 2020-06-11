package pay.service;

import org.springframework.stereotype.Service;
import pay.entity.Price;

import java.util.Optional;

@Service
public interface PriceService  {

    public Price findById(Long id);

}
