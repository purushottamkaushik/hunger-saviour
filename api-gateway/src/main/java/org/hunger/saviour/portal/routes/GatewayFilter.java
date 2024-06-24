package org.hunger.saviour.portal.routes;

import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.exceptions.UnauthorizedAcessException;
import org.hunger.saviour.portal.proxy.WebClientBuilderProxy;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class GatewayFilter extends AbstractGatewayFilterFactory<GatewayFilter.Config> {


    private RouteValidator routeValidator;
    private WebClientBuilderProxy webClientBuilderProxy;

    public GatewayFilter(RouteValidator routeValidator, WebClientBuilderProxy webClientBuilderProxy) {
        super(Config.class);
        this.routeValidator = routeValidator;
        this.webClientBuilderProxy = webClientBuilderProxy;
    }

    @Override
    public org.springframework.cloud.gateway.filter.GatewayFilter apply(GatewayFilter.Config config) {
        return ((exchange, chain) -> {
            System.out.println("Hello");

            System.out.println("Request coming from " + exchange.getRequest().getPath() + ".. ");
            if (routeValidator.exchangeEndpoints.test(exchange.getRequest())) {
                if (exchange.getRequest().getHeaders().containsKey("Authorization") == Boolean.FALSE) {
                    throw new UnauthorizedAcessException("Missing authorization header");
                }
                String headers = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
                if (headers.startsWith("Bearer ")) {
                    headers = headers.substring(7);
                }

                return validateToken(headers).flatMap(isValid -> {
                    if (isValid) {
                        System.out.println("token is valid forwarding to another microservices");
                       return chain.filter(exchange);
                    } else {
                        System.out.println("token is invalid ");
                        return chain.filter(exchange);
                    }
                });
            }

            return chain.filter(exchange);
        });


    }


    Mono<Boolean> validateToken(String token) {
        return this.webClientBuilderProxy.validateToken(token);
    }

    public static class Config {
    }
}
