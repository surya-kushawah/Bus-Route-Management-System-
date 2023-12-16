package com.bus.management.service.impl;


import com.bus.management.dto.UserDTO;
import com.bus.management.entity.RoleEntity;
import com.bus.management.entity.UserEntity;
import com.bus.management.repository.RoleRepository;
import com.bus.management.repository.UserRepository;
import com.bus.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity registerUser(UserDTO userDTO) {

        // Map role DTO to RoleEntity (assuming RoleDTO is similar to UserDTO)
        UserEntity userEntity = mapDtoToEntity(userDTO);
        return userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return UserDetailsImpl.build(userEntity);
    }

    private UserEntity mapDtoToEntity(UserDTO userDTO) {
        /**
         * Uncomment this code before go live
         *               userRole = roleRepository.findByName("ROLE_USER")
         *              .orElseThrow(() -> new EntityNotFoundException("Role not found"));
         */

        // This is for testing
        RoleEntity userRole;
        if (userDTO.getRole().equalsIgnoreCase("ROLE_USER")) {
            userRole = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        } else {
            userRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        }


        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setRoles(Collections.singletonList(userRole));

        return userEntity;
    }

    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }
}