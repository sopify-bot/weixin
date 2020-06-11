package pay.service;

import org.springframework.stereotype.Service;
import pay.entity.Product;
import pay.entity.ProductPage;

import java.util.List;

@Service
public interface ProductService {

    ProductPage findProduct(String productId);

    /***
     * 商品以后做翻页这里要改造
     * @return
     */
    List<Product> findAll();


}
