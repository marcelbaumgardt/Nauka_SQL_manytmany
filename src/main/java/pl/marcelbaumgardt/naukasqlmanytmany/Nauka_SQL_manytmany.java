package pl.marcelbaumgardt.naukasqlmanytmany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.marcelbaumgardt.naukasqlmanytmany.dao.CustomerDao;
import pl.marcelbaumgardt.naukasqlmanytmany.dao.ItemDao;
import pl.marcelbaumgardt.naukasqlmanytmany.dao.OrderDao;
import pl.marcelbaumgardt.naukasqlmanytmany.model.Customer;
import pl.marcelbaumgardt.naukasqlmanytmany.model.Item;
import pl.marcelbaumgardt.naukasqlmanytmany.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Nauka_SQL_manytmany {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Nauka_SQL_manytmany.class, args);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        ItemDao itemDao = context.getBean(ItemDao.class);
        OrderDao orderDao = context.getBean(OrderDao.class);

        Customer customer = new Customer("marcel", "baumgardt");
        List<Order> orders=new ArrayList<>();
        Order order = new Order("chuj wie co");



        Item item=new Item("zamowienie 1",10.10);
        Item item1 = new Item("zamowienie 2", 20.20);
        List<Item> items = Arrays.asList(item, item1);
        order.setItems(items);
        orders.add(order);
        customer.setOrders(orders);
        customerDao.save(customer);

//        order.setCustomer(customer);
//        orderDao.save(order);
//
//        itemDao.save(item);
//        itemDao.save(item1);
//
//        orderDao.addItemsToOrder(1L,item,item1);




    }
}
