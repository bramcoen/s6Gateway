package com.bram.s6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S6Application {

	public static void main(String[] args) {
		SpringApplication.run(S6Application.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes().
				route("messaging", r->  r.path("/messaging/*")
						.uri("https://messaging:443"))
				.build();
	}
}
