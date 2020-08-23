package com.isaccanedo.security.springsecurityauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaccanedo.security.springsecurityauthserver.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
