package com.demospring.springdemoproject.service.interfaces;

import com.demospring.springdemoproject.models.entity.autorizations.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    Optional<User> findUserById(Long id);

}
