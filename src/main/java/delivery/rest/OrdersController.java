package delivery.rest;

import delivery.model.Orders;
import delivery.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Orders> getOrdersById(@PathVariable(value = "id") Integer ordersId) {
        Orders orders = ordersRepository.findOne(ordersId);

        if (orders == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(orders);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = "application/json")
    public Orders createOrders(@Valid @RequestBody Orders orders) {
        return ordersRepository.save(orders);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Orders updateOrders(@Valid @RequestBody Orders orders) {
        return ordersRepository.save(orders);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Orders> deleteOrders(@PathVariable(value = "id") Integer ordersId) {
        Orders orders = ordersRepository.findOne(ordersId);

        if (orders == null) {
            return ResponseEntity.notFound().build();
        } else {
            ordersRepository.delete(orders);
        }

        return ResponseEntity.ok().body(orders);
    }
}
