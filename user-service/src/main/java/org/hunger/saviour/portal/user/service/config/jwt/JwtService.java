package org.hunger.saviour.portal.user.service.config.jwt;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.user.service.dtos.RsaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtService {

    private final RsaConfiguration rsaConfiguration;

    @Autowired private JwtEncoder jwtEncoder;
    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));


        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .claim("scope",authorities)
                .expiresAt(now.plus(10, ChronoUnit.HOURS))
                .issuer("self")
                .subject(authentication.getName())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();


    }


    public Boolean validateToken( String token) throws Exception {
        SignedJWT jwt = SignedJWT.parse(token);

        JWSVerifier jwsVerifier = new RSASSAVerifier(rsaConfiguration.getPublicKey());
        return jwt.verify(jwsVerifier);

    }
}
