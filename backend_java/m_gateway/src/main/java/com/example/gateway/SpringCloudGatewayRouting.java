package com.example.gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class SpringCloudGatewayRouting {

	/*@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("paymentId", r -> r.path("/department/**").uri("http://localhost:8081")) // static
				.route("orderId", r -> r.path("/designation/**").uri("http://localhost:8082")) // static routingg

				.route(r -> r.path("/MS1/**").uri("lb://department-service")) // dynamic routing
				.route(r -> r.path("/MS2/**").uri("lb://designation-service")) // dynamic routing
				.build();
	}*/

	@Bean
	public GlobalFilter globalFilter() {
		return (exchange, chain) -> {
			System.out.println("First Global filter"+exchange.getRequest().getPath());
			System.out.println("First Global filter"+exchange.getRequest().getMethod());
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("Second Global filter");
			}));
		};
	}
}
