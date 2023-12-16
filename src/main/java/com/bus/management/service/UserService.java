package com.bus.management.service;


import com.bus.management.dto.UserDTO;
import com.bus.management.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    UserEntity registerUser(UserDTO userDTO);
    UserDetails loadUserByUsername(String username);
}
