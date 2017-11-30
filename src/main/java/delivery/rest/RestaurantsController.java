package delivery.rest;

import delivery.model.Restaurants;
import delivery.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestaurantsController {
    @Autowired
    RestaurantsRepository restaurantsRepository;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json")
    public List<Restaurants> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Restaurants> getRestaurantsById(@PathVariable(value = "id") Integer restaurantsId) {
        Restaurants restaurants = restaurantsRepository.findOne(restaurantsId);

        if (restaurants == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(restaurants);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST, produces = "application/json")
    public Restaurants createRestaurants(@Valid @RequestBody Restaurants restaurants) {
        return restaurantsRepository.save(restaurants);
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Restaurants updateRestaurants(@Valid @RequestBody Restaurants restaurants) {
        return restaurantsRepository.save(restaurants);
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Restaurants> deleteRestaurants(@PathVariable(value = "id") Integer restaurantsId) {
        Restaurants restaurants = restaurantsRepository.findOne(restaurantsId);

        if (restaurants == null) {
            return ResponseEntity.notFound().build();
        } else {
            restaurantsRepository.delete(restaurants);
        }

        return ResponseEntity.ok().body(restaurants);
    }
}
