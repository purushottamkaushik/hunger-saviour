package org.hunger.saviour.portal.user.service.config.services;

import org.hunger.saviour.portal.user.service.entities.UserEntity;
import org.hunger.saviour.portal.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity optionalUserEntity = this.userRepository.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Username ::" + username + " not found"));

        System.out.println("User name " + username + "found ... ");

        return org.springframework.security.core.userdetails.User
                .withUsername(optionalUserEntity.getUsername())
                .password(optionalUserEntity.getPassword())
                .authorities(optionalUserEntity.getAuthorities())
                .accountExpired(!optionalUserEntity.isAccountNonExpired())
                .accountLocked(!optionalUserEntity.isAccountNonLocked())
                .credentialsExpired(!optionalUserEntity.isCredentialsNonExpired())
                .disabled(!optionalUserEntity.isEnabled())
                .build();

    }
}
