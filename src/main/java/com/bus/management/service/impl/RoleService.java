package com.bus.management.service.impl;

import com.bus.management.entity.RoleEntity;
import com.bus.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void insertRoles() {
        saveRole("ROLE_ADMIN");
        saveRole("ROLE_USER");
    }

    private void saveRole(String roleName) {
        Optional<RoleEntity> roleOptional = roleRepository.findByName(roleName);
        if (roleOptional.isEmpty()) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setName(roleName);
            roleRepository.save(roleEntity);
        }
    }
}