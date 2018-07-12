package pl.marcelbaumgardt.naukasqlmanytmany.dao;

import org.springframework.stereotype.Repository;
import pl.marcelbaumgardt.naukasqlmanytmany.model.Item;
import pl.marcelbaumgardt.naukasqlmanytmany.model.Order;

@Repository
public class OrderDao extends GenericDao<Order,Long> {

    public void addItemsToOrder(Long orderId, Item... items){
        Order order = get(orderId);
        if (order!=null) {
            for (Item o:items) {
                order.getItems().add(o);
            }
        }
    }
}
