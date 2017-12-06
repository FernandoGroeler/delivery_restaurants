package delivery.repository;

import delivery.model.Orders;
import delivery.model.RestaurantsItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
