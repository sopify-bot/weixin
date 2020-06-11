//package pay;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class PayApplicationTests {
//
//
//    @Autowired
//    JavaMailSender javaMailSender;
//
//    @Test
//    public void contextLoads() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setSubject("这是一封测试邮件");
//        message.setFrom("80258153@qq.com");
//        message.setTo("80258153@qq.com");
//        message.setSentDate(new Date());
//        message.setText("这是测试邮件的正文");
//        javaMailSender.send(message);
//    }
//
//
//}
