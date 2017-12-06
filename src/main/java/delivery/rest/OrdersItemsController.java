package delivery.rest;

import delivery.model.OrdersItems;
import delivery.model.RestaurantsItems;
import delivery.repository.OrdersItemsRepository;
import delivery.repository.RestaurantsItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrdersItemsController {
    @Autowired
    OrdersItemsRepository ordersItemsRepository;

    @RequestMapping(value = "/orders/items", method = RequestMethod.GET, produces = "application/json")
    public List<OrdersItems> getAllOrdersItems() {
        return ordersItemsRepository.findAll();
    }

    @RequestMapping(value = "/orders/items/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<OrdersItems> getOrdersItemsById(@PathVariable(value = "id") Integer ordersItemsId) {
        OrdersItems ordersItems = ordersItemsRepository.findOne(ordersItemsId);

        if (ordersItems == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ordersItems);
    }

    @RequestMapping(value = "/orders/items/order/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<OrdersItems> getAllOrdersItemsByOrder(@PathVariable(value = "id") Integer ordersId) {
        return ordersItemsRepository.findByIdOrders(ordersId);
    }

    @RequestMapping(value = "/orders/items", method = RequestMethod.POST, produces = "application/json")
    public OrdersItems createOrdersItems(@Valid @RequestBody OrdersItems ordersItems) {
        return ordersItemsRepository.save(ordersItems);
    }

    @RequestMapping(value = "/orders/items/{id}", method = RequestMethod.PUT, produces = "application/json")
    public OrdersItems updateOrdersItems(@Valid @RequestBody OrdersItems ordersItems) {
        return ordersItemsRepository.save(ordersItems);
    }

    @RequestMapping(value = "/orders/items/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<OrdersItems> deleteOrdersItems(@PathVariable(value = "id") Integer ordersItemsId) {
        OrdersItems ordersItems = ordersItemsRepository.findOne(ordersItemsId);

        if (ordersItems == null) {
            return ResponseEntity.notFound().build();
        } else {
            ordersItemsRepository.delete(ordersItems);
        }

        return ResponseEntity.ok().body(ordersItems);
    }
}
