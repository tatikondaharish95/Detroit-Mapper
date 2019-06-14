package com.pal.detroitmapper;

import com.pal.detroitmapper.apartmentsapi.ApartmentsServlet;
import com.pal.detroitmapper.restaurantsapi.RestaurantsServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

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
	public ServletRegistrationBean apartmentServletRegistration(ApartmentsServlet apartmentsServlet) {
		return new ServletRegistrationBean(apartmentsServlet, "/apartments/*");
	}

}
