package delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "ordersitems")
public class OrdersItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idrestaurantsitems")
    private RestaurantsItems restaurantsItems;

    @ManyToOne
    @JoinColumn(name = "idorders")
    private Orders orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RestaurantsItems getRestaurantsItems() {
        return restaurantsItems;
    }

    public void setRestaurantsItems(RestaurantsItems restaurantsItems) {
        this.restaurantsItems = restaurantsItems;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
