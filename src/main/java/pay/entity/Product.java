package pay.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Table(name = "product")
@Accessors(chain = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;


    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "proId",length = 8)
    private String proId;

    @Getter
    @Setter
    private String productName;

    /***
     * 支付理由
     */
    @Getter
    @Setter
    private String reasonForPayment;

    /***
     * 产品描述 句号 分割;
     */
    @Getter
    @Setter
    private String productDescribe;
    /***
     * 确认订单页面的标题;
     */
    @Getter
    @Setter
    private String confirmTitle;
    /***
     * 确认订单描述,这个地方;
     */
    @Getter
    @Setter
    private String confirmDescribe;


    @Getter
    @Setter
    private String priceId;



}
