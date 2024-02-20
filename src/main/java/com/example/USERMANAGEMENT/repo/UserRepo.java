package com.example.USERMANAGEMENT.repo;

import com.example.USERMANAGEMENT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findFirstByUserEmail(String newEmail);

    User findFirstByuserEmail(String signInEmail);
}
