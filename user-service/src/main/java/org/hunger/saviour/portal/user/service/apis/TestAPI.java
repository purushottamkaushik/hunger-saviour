package org.hunger.saviour.portal.user.service.apis;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestAPI {


    @PreAuthorize("hasRole(ROLE_ADMIN)")
    @GetMapping("/private")
    public String signUpUser() {
        return "Signing up";
    }

    @GetMapping("/public")
    public String loginUser() {
        return "PUBLIC API";
    }
}