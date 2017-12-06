package delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
@Entity
@Table(name = "ordersitems")
public class OrdersItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotBlank
    private int quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "iditems")
    private RestaurantsItems item;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idorder")
    private Orders order;

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

    public RestaurantsItems getItem() {
        return item;
    }

    public void setItem(RestaurantsItems item) {
        this.item = item;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
