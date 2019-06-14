package com.pal.detroitmapper;

import com.pal.detroitmapper.restaurantsapi.RestaurantsServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import pal.com.detroitmapper.ServiceCredentials;

@SpringBootApplication
public class DetroitMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetroitMapperApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean actionServletRegistration(RestaurantsServlet restaurantsServlet) {
		return new ServletRegistrationBean(restaurantsServlet, "/restaurants/*");
	}

	@Bean
	ServiceCredentials serviceCredentials(@Value("${vcap.services}") String vcapServices) {
		return new ServiceCredentials(vcapServices);
	}
}
