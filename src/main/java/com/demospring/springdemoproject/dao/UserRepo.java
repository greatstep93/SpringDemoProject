package com.demospring.springdemoproject.dao;

import com.demospring.springdemoproject.models.entity.autorizations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query ("SELECT p FROM User p JOIN FETCH p.roles where p.username = (:username)")
    User findByUsername(String username);
}
