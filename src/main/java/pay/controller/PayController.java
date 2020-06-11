package pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pay.entity.Order;
import pay.entity.PayPage;
import pay.entity.Price;
import pay.entity.Product;
import pay.service.OrderService;
import pay.service.PriceService;
import pay.service.ProductService;
import org.springframework.core.env.Environment;

@Controller
public class PayController {

    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    PriceService priceService;

    @Autowired
    private Environment env;

    @RequestMapping("/product/{proId}")
    public  String order(Model model, @PathVariable(name = "proId") String proId){
        model.addAttribute("productPage",productService.findProduct(proId));
        model.addAttribute("proId",proId);
        return "product";
    }

    @RequestMapping("/order")
    public  String order(
            @RequestParam(name = "petName") String petName
            ,@RequestParam(name = "priceId") Long priceId
            ,@RequestParam(name = "email") String email
            ,@RequestParam(name = "message") String message
            ,@RequestParam(name = "proId") String proId
            ,Model model){
        System.out.println(">>>>>>>"+env.getProperty("qrcodePath"));
        Product product=productService.findProduct(proId).getProduct();
        Price price=priceService.findById(priceId);
        Order order=new Order().setPetName(petName).setPrice(price.getPrice()).setEmail(email).setMessage(message).setPayment(0).setProductId(proId).setProductName(product.getProductName());
        orderService.save(order);
        model.addAttribute("payPage",new PayPage().setProduct(product).setOrder(order));
        model.addAttribute("proId",proId);
        model.addAttribute("price",price.setOrcodeName("/wechat/"+price.getOrcodeName()));
        return "pay";
    }


    @RequestMapping("/pay")
    public  String pay(Model model,@RequestParam(name = "proId") String proId,@RequestParam(name = "priceId") Long priceId){
        Price price=priceService.findById(priceId);
        model.addAttribute("productPage",productService.findProduct(proId));
        model.addAttribute("price",price);
        return "confirm";
    }

    @RequestMapping("/panel/{type}")
    public  String panel(Model model,@PathVariable(name = "type") Integer type){
        //如果是0,就是商品展示;如果是1代表是订单展示
        if(type==0){
            model.addAttribute("products",productService.findAll());
        }else if(type==1){

        }
        return "panel";
    }

    @RequestMapping("/panel/proadd")
    public  String proadd(){

        return "productadd";
    }
    @RequestMapping("/panel/order")
    public  String prodel(Model model){
        model.addAttribute("orders",orderService.findAll());
        return "order";
    }

    @RequestMapping("/index")
    public  String index(){

        return "index";
    }


}

