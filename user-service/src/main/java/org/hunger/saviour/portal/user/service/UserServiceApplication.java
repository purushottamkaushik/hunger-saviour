package org.hunger.saviour.portal.user.service;

import org.apache.hc.core5.reactor.Command;
import org.hunger.saviour.portal.user.service.dtos.RsaConfiguration;
import org.hunger.saviour.portal.user.service.entities.RoleEntity;
import org.hunger.saviour.portal.user.service.entities.UserEntity;
import org.hunger.saviour.portal.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(RsaConfiguration.class)
public class UserServiceApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (((List)userRepository.findAll()).isEmpty()){
            UserEntity user = UserEntity.builder()
                    .username("purushottam")
                    .password(passwordEncoder.encode("password"))
                    .roles(List.of(new RoleEntity("ADMIN")))
                    .build();
            userRepository.save(user);
            System.out.println("USER SAVEDDDDD");
        }

    }
}
