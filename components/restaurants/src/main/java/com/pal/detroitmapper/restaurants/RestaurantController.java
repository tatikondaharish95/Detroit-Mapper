package com.pal.detroitmapper.restaurants;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        this.repository.addRestro(restaurant);
    }

    @DeleteMapping("/{restroId}")
    public void deleteRestaurant(@PathVariable Long restroId) {
        this.repository.deleteRestroId(restroId);
    }

    @GetMapping
    public List<Restaurant> find(@RequestParam(name = "field", required = false) String field,
                            @RequestParam(name = "key", required = false) String key,
                            @RequestParam(name = "start", required = false) Integer start,
                            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        if (field != null && key != null) {
            return repository.findRange(field, key, start, pageSize);
        } else if (start != null && pageSize != null) {
            return repository.findAll(start, pageSize);
        }
        return repository.getRestaurants();
    }

    @GetMapping("/count")
    public int count(@RequestParam(name = "field", required = false) String field,
                     @RequestParam(name = "key", required = false) String key) {
        if (field != null && key != null) {
            return repository.count(field, key);
        }
        return repository.countAll();
    }
}
