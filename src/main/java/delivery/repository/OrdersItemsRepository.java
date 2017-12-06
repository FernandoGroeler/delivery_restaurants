package delivery.repository;

import delivery.model.OrdersItems;
import delivery.model.RestaurantsItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersItemsRepository extends JpaRepository<OrdersItems, Integer> {
    @Query(value = "SELECT * FROM ordersitems WHERE idorder = ?1", nativeQuery = true)
    List<OrdersItems> findByIdOrders(int idOrders);
}
