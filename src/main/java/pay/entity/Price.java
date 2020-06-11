package pay.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name = "price")
@Accessors(chain = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;


    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "priceId",length = 8)
    private String priceId;
    /***
     * 二维码路径
     */
    @Getter
    @Setter
    private String orcodeName;

    /***
     * 价格
     */
    @Getter
    @Setter
    private Float price;

    /***
     * 服务描述;
     */
    @Getter
    @Setter
    @Column(name ="description" )
    private String description;
    

}
