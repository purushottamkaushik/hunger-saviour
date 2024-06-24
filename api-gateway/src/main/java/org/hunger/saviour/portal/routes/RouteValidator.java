package org.hunger.saviour.portal.routes;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;


@Component
public class RouteValidator {


    private List<String> openApiEndpoints = List.of(
            "/users/login",
            "/users/signup",
            "/users/validate"
    );

    public Predicate<ServerHttpRequest> exchangeEndpoints =
            request -> openApiEndpoints.stream()
                    .noneMatch(uri-> request.getURI().getPath().equals(uri));

}
