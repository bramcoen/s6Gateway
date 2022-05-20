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
		return builder.routes()
				.route("rabbit", r->  r.path("/rabbit/*")
				.uri("http://rabbitmq:15672/")).
				route("messaging", r->  r.path("/*")
						.uri("http://frontend:3000/"))
				.build();
	}
}
