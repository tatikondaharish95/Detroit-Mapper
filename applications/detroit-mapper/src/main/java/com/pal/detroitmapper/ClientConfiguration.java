package com.pal.detroitmapper;

import com.pal.detroitmapper.restaurantsapi.RestaurantsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {
    @Value("${restaurants.url:http://localhost:8081/restaurants}") String restaurantsUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public RestaurantsClient restaurantsClient(RestOperations operations) {
        return new RestaurantsClient(restaurantsUrl, operations);
    }
}
