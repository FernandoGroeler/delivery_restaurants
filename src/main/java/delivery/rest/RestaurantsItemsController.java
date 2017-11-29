package delivery.rest;

import delivery.model.RestaurantsItems;
import delivery.repository.RestaurantsItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantsItemsController {
    @Autowired
    RestaurantsItemsRepository restaurantsItemsRepository;

    @RequestMapping(value = "/restaurants/items", method = RequestMethod.GET, produces = "application/json")
    public List<RestaurantsItems> getAllRestaurantsItems() {
        return restaurantsItemsRepository.findAll();
    }

    @RequestMapping(value = "/restaurants/items/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<RestaurantsItems> getRestaurantsItemsById(@PathVariable(value = "id") Integer restaurantsItemsId) {
        RestaurantsItems restaurantsItems = restaurantsItemsRepository.findOne(restaurantsItemsId);

        if (restaurantsItems == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(restaurantsItems);
    }

    @RequestMapping(value = "/restaurants/items", method = RequestMethod.POST, produces = "application/json")
    public RestaurantsItems createRestaurantsItems(@Valid @RequestBody RestaurantsItems restaurantsItems) {
        return restaurantsItemsRepository.save(restaurantsItems);
    }

    @RequestMapping(value = "/restaurants/items/{id}", method = RequestMethod.PUT, produces = "application/json")
    public RestaurantsItems updateRestaurantsItems(@Valid @RequestBody RestaurantsItems restaurantsItems) {
        return restaurantsItemsRepository.save(restaurantsItems);
    }

    @RequestMapping(value = "/restaurants/items/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<RestaurantsItems> deleteRestaurantsItems(@PathVariable(value = "id") Integer restaurantsItemsId) {
        RestaurantsItems restaurantsItems = restaurantsItemsRepository.findOne(restaurantsItemsId);

        if (restaurantsItems == null) {
            return ResponseEntity.notFound().build();
        } else {
            restaurantsItemsRepository.delete(restaurantsItems);
        }

        return ResponseEntity.ok().body(restaurantsItems);
    }

}
