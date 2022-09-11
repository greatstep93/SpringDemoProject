package com.demospring.springdemoproject.service.impl;

import com.demospring.springdemoproject.dao.UserRepo;
import com.demospring.springdemoproject.models.entity.autorizations.User;
import com.demospring.springdemoproject.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepo.saveAndFlush(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

}
