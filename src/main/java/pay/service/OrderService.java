package pay.service;

import org.springframework.stereotype.Service;
import pay.entity.Order;
import pay.entity.ProductPage;

import java.util.List;

@Service
public interface OrderService {

    Order save(Order order);


    Order findFirstById(Long id);

    List<Order> findAll();
}
