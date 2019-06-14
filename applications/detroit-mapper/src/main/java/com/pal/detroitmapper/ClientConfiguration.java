package com.pal.detroitmapper;

import com.pal.detroitmapper.appartmentsapi.AppartmentsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {
    @Value("${appartments.url:http://localhost:8081/appartments}") String appartmentUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public AppartmentsClient appartmentsClient(RestOperations operations) {
        return new AppartmentsClient(appartmentUrl, operations);
    }


}
