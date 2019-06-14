package com.pal.detroitmapper;

import com.pal.detroitmapper.apartmentsapi.ApartmentsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {
    @Value("${apartments.url:http://localhost:8081/apartments}") String apartmentUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public ApartmentsClient apartmentsClient(RestOperations operations) {
        return new ApartmentsClient(apartmentUrl, operations);
    }


}
