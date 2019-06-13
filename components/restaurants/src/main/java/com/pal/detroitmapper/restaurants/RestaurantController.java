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
    public List<Restaurant> list() {
        return this.repository.findAll();
    }

    @GetMapping("/{restroId}")
    public Restaurant getOne(@PathVariable Long restroId) {
        return this.repository.find(restroId);
    }

    @PutMapping
    public void updateRestro(@RequestBody Restaurant restaurant) {
        this.repository.updateRestro(restaurant);
    }
}
