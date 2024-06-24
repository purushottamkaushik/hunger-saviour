package org.hunger.saviour.portal;

import org.hunger.saviour.portal.proxy.WebClientBuilderProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication

public class ApiGateWayApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApiGateWayApplication.class , args);
    }


    @Bean
    @LoadBalanced

    @Primary
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }


}
