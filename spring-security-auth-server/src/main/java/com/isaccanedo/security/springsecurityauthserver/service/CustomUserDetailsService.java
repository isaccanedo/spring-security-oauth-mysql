package com.isaccanedo.security.springsecurityauthserver.service;

import com.isaccanedo.security.springsecurityauthserver.model.CustomUserDetails;
import com.isaccanedo.security.springsecurityauthserver.model.Users;
import com.isaccanedo.security.springsecurityauthserver.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> usersOptional = usersRepository.findByName(username);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username não encontrado!"));
        return usersOptional
                .map(CustomUserDetails::new)
                .get();
    }
}
