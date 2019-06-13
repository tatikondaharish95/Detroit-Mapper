package com.pal.detroitmapper;

import com.pal.detroitmapper.restaurantsapi.RestaurantFixtures;
import com.pal.detroitmapper.restaurantsapi.RestaurantInfo;
import com.pal.detroitmapper.restaurantsapi.RestaurantsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {

    private final RestaurantsClient restaurantsClient;
    private final RestaurantFixtures restaurantFixtures;

    public HomeController(RestaurantsClient restaurantsClient, RestaurantFixtures restaurantFixtures) {
        this.restaurantsClient = restaurantsClient;
        this.restaurantFixtures = restaurantFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (RestaurantInfo info: restaurantFixtures.load()) {
            restaurantsClient.addRestaurant(info);
        }
        model.put("restaurants", restaurantsClient.getRestaurants());

        return "setup";
    }
}
