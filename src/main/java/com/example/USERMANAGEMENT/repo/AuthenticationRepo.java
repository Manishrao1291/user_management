package com.example.USERMANAGEMENT.repo;

import com.example.USERMANAGEMENT.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepo extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findFirstByTokenValue(String token);
}
