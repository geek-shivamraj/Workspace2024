package com.srvcode.microservices;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p-> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/docker-currency-exchange/**")
                        .uri(("lb://docker-currency-exchange")))
                .route(p -> p.path("/docker-currency-conversion/**")
                        .uri(("lb://docker-currency-conversion")))
                .route(p -> p.path("/docker-currency-conversion-feign/**")
                        .uri(("lb://docker-currency-conversion")))
                .route(p -> p.path("/docker-currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/docker-currency-conversion-new/(?<segment>.*)",
                                "/docker-currency-conversion-feign/${segment}"))
                        .uri("lb://docker-currency-conversion"))
                .build();
    }
}





