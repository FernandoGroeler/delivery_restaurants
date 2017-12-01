package delivery.repository;

import delivery.model.RestaurantsItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantsItemsRepository extends JpaRepository<RestaurantsItems, Integer> {
    @Query(value = "SELECT * FROM restaurantsitems WHERE idrestaurants = ?1", nativeQuery = true)
    List<RestaurantsItems> findByIdRestaurants(int idRestaurants);
}
