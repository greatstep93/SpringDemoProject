package com.demospring.springdemoproject.dao;

import com.demospring.springdemoproject.models.entity.autorizations.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
