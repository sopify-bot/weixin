package pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pay.entity.Order;
import pay.entity.Product;
import pay.entity.ProductPage;
import pay.repository.OrderRepository;
import pay.repository.PriceRepository;
import pay.repository.ProductRepository;

import java.util.List;

@Service
public class OrderServiceI implements  OrderService {


    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
       return orderRepository.save(order);
    }

    @Override
    public Order findFirstById(Long id) {
        return orderRepository.findFirstById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
