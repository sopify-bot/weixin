package pay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import java.util.List;

@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class ProductPage {

    @Getter @Setter
   private Product product;

    @Getter @Setter
    private List<Price> priceList;


}
