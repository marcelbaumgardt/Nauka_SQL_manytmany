package pl.marcelbaumgardt.naukasqlmanytmany.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    private String details;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "orders_items",
                joinColumns = {@JoinColumn(name = "order_id",referencedColumnName = "id_order")},
                inverseJoinColumns = {@JoinColumn(name = "item_id",referencedColumnName = "id_item")})
    private List<Item> items=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(String details) {
        this.details = details;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", items=" + items +
                ", client=" + customer +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDetails() {

        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
