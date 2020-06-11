package pay.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name = "iorder")
@Accessors(chain = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    /***
     * 订单
     * 昵称
     */
    @Getter
    @Setter
    private String petName;

    /***
     * 订单
     * 金额
     */
    @Getter
    @Setter
    private Float price;

    /***
     * 订单
     * email
     */
    @Getter
    @Setter
    private String email;
    /***
     * 订单
     * 留言
     */
    @Getter
    @Setter
    private String message;

    /***
     * 订单
     * 支付方式 0 是微信，目前也只支持微信;
     * 支付方式 1 是支付宝,
     */
    @Getter
    @Setter
    private int payment;

    /***
     * 产品ID
     */
    @Getter
    @Setter
    private String productId;


    /***
     * 产品名称
     */
    @Getter
    @Setter
    private String productName;


}
