package org.hunger.saviour.portal.user.service.dtos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


@Service
@ConfigurationProperties(prefix = "rsa")
@Data
public class RsaConfiguration {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;



}
