package com.pal.detroitmapper;

import com.pal.detroitmapper.apartmentsapi.ApartmentsClient;
import com.pal.detroitmapper.restaurantsapi.RestaurantsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {
    @Value("${restaurants.url:http://localhost:8081/restaurants}") String restaurantsUrl;
    @Value("${apartments.url:http://localhost:8082/apartments}") String apartmentsUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public RestaurantsClient restaurantsClient(RestOperations operations) {
        return new RestaurantsClient(restaurantsUrl, operations);
    }

    @Bean
    public ApartmentsClient apartmentsClient(RestOperations operations) {
        return new ApartmentsClient(apartmentsUrl, operations);
    }
}
