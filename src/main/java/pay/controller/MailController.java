package pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pay.entity.Order;
import pay.service.OrderService;

import java.util.Date;

@RestController
public class MailController {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    OrderService orderService;

    @RequestMapping("/mail/{orderId}")
    public  String mail(@PathVariable(name = "orderId") Long orderId){
        Order order= orderService.findFirstById(orderId);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>调用到了发邮件环节....");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("来自客户的订单:");
        message.setFrom("80258153@qq.com");
        message.setTo("80258153@qq.com");
        message.setSentDate(new Date());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("产品ID："+order.getProductId())
                .append("产品名称: "+order.getProductName()+" ")
                .append(" 价格: "+order.getPrice()+" ")
                .append("订单号: "+orderId+" ")
                .append("客户昵称: "+order.getPetName()+" ")
                .append("客户邮箱:"+order.getEmail()+" ")
                .append("客户留言:"+order.getMessage()+" ");
        message.setText(stringBuilder.toString());
        javaMailSender.send(message);
        return "1";

    }
}
