package delivery.rest;

import delivery.model.Restaurants;
import delivery.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantsConstroller {
    @Autowired
    RestaurantsRepository restaurantsRepository;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json")
    public List<Restaurants> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }
}
