package pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay.entity.Product;
import pay.entity.ProductPage;
import pay.repository.PriceRepository;
import pay.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceI implements  ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    PriceRepository priceRepository;

    @Override
    public ProductPage findProduct(String proId) {
        Product product=productRepository.findByProId(proId);
        return new ProductPage().setProduct(product).setPriceList(priceRepository.findAllByPriceId(product.getPriceId()));
    }

    /***
     * 商品以后做翻页这里要改造
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
