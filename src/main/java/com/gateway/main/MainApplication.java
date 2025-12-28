package com.gateway.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	/**
	 * Configure gateway routes programmatically (alternative to application.properties)
	 * You can use either this approach or the properties file, or combine both
	 */
	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				// Example route - uncomment and configure as needed
				// .route("food-service", r -> r
				// 		.path("/api/food/**")
				// 		.filters(f -> f.stripPrefix(1))
				// 		.uri("http://localhost:8081"))
				.build();
	}

}
