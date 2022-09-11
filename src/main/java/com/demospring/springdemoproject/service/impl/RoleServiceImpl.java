package com.demospring.springdemoproject.service.impl;

import com.demospring.springdemoproject.dao.RoleRepo;
import com.demospring.springdemoproject.models.entity.autorizations.Role;
import com.demospring.springdemoproject.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleRepo.saveAndFlush(role);
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleRepo.findById(id);
    }
}
