package com.demospring.springdemoproject.service.interfaces;

import com.demospring.springdemoproject.models.entity.autorizations.Role;

import java.util.Optional;

public interface RoleService {

    void saveRole(Role role);

    void deleteRoleById(Long id);

    void updateRole(Role role);

    Optional<Role> findRoleById(Long id);
}
