package org.hunger.saviour.portal.proxy;


import lombok.RequiredArgsConstructor;
import org.hunger.saviour.portal.dtos.AuthRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class WebClientBuilderProxy {


    private final WebClient.Builder webClientBuilder;


    public Mono<String> getToken(AuthRequest request) {


        return Mono.just(webClientBuilder.build()
                .post()
                .uri("http://user-service/user/login/")
                .bodyValue(request)
                .accept(MediaType.APPLICATION_JSON)

                .retrieve()
                .bodyToMono(String.class)
                .block());
    }

    public Mono<Boolean> validateToken(String token) {
        return Mono.just(webClientBuilder.build()
                .get()
                .uri("http://user-service/users/validate?token=" + token)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());

    }

}
