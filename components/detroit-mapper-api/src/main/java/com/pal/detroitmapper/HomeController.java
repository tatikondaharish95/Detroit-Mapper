package com.pal.detroitmapper;

import com.pal.detroitmapper.apartmentsapi.ApartmentFixtures;
import com.pal.detroitmapper.apartmentsapi.ApartmentInfo;
import com.pal.detroitmapper.apartmentsapi.ApartmentsClient;
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

    private final ApartmentsClient apartmentsClient;
    private final ApartmentFixtures apartmentFixtures;

    public HomeController(RestaurantsClient restaurantsClient, RestaurantFixtures restaurantFixtures,
                          ApartmentsClient apartmentsClient, ApartmentFixtures apartmentFixtures) {
        this.restaurantsClient = restaurantsClient;
        this.restaurantFixtures = restaurantFixtures;

        this.apartmentsClient = apartmentsClient;
        this.apartmentFixtures = apartmentFixtures;
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
        for (ApartmentInfo info: apartmentFixtures.load()) {
            apartmentsClient.addApartment(info);
        }
        model.put("restaurants", restaurantsClient.getRestaurants());
        model.put("apartments", apartmentsClient.getApartments());

        return "setup";
    }
}
