package org.hunger.saviour.portal.user.service.apis;

import org.hunger.saviour.portal.user.service.config.jwt.JwtService;
import org.hunger.saviour.portal.user.service.dtos.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
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

        System.out.println("HELLOO");
//        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername()
//                , authRequest.getPassword()));
//
//        System.out.println("Authentication PURUSHOTAAM: " + authentication);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//      UserEntity userEntity =  (UserEntity) authentication.getPrincipal();
//        return this.jwtService.generateToken(authentication);

        return null;
    }
}