package delivery.repository;

import delivery.model.RestaurantsItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantsItemsRepository extends JpaRepository<RestaurantsItems, Integer> {
}
