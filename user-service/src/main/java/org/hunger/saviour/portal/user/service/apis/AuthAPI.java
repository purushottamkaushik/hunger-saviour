package org.hunger.saviour.portal.user.service.apis;

import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.user.service.config.jwt.JwtService;
import org.hunger.saviour.portal.user.service.dtos.AuthRequest;
import org.hunger.saviour.portal.user.service.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class AuthAPI {

    @Autowired private AuthenticationManager authenticationManager;

    @Autowired private UserDetailsService userDetailsService;

    @Autowired private JwtService jwtService;

    @GetMapping("/signup")
    public String signUpUser() {
        return "Signing up";
    }

    @PostMapping("/login")

    public String loginUser(@RequestBody AuthRequest authRequest) {

        log.debug("==========================HELLO========================================================");
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername()
                , authRequest.getPassword()));

        log.debug("Authentication PURUSHOTAAM: " + authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);
      UserEntity userEntity =  (UserEntity) authentication.getPrincipal();
        return this.jwtService.generateToken(authentication);

    }

    @GetMapping("/validate")
    public Boolean validateToken(@RequestParam("token") String token) throws Exception{
       return this.jwtService.validateToken(token);

    }
}