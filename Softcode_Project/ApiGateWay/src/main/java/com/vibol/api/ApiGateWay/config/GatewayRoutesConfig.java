package com.vibol.api.ApiGateWay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.removeRequestHeader;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class GatewayRoutesConfig {

    @Value("${app.resourceserver.base-url}")
    private String resourceServerBaseUrl;

    @Bean
    public RouterFunction<ServerResponse> gatewayRoutes() {
        return route("users-status-check")
                .GET("/users/**", http())          // ✅ handler has NO args
                .before(uri(resourceServerBaseUrl))          // ✅ set downstream target here
                .filter(removeRequestHeader("Cookie"))
                .build();
    }
}