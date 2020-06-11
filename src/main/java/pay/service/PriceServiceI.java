package pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay.entity.Price;
import pay.repository.PriceRepository;

import java.util.Optional;

@Service
public class PriceServiceI implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public Price findById(Long id) {
        return priceRepository.findById(id).get();
    }
}
