package com.sofy.casestudy.capstone.kazhan.service;

import com.sofy.casestudy.capstone.kazhan.dto.UserDTO;
import com.sofy.casestudy.capstone.kazhan.entity.Role;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import com.sofy.casestudy.capstone.kazhan.repository.RoleRepository;
import com.sofy.casestudy.capstone.kazhan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Check if it's the first user and assign the admin role
        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                adminRole = checkRoleExist("ROLE_ADMIN");
            }
            user.setRoles(Collections.singletonList(adminRole));
        } else {
            // For regular users, assign the default role
            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                userRole = checkRoleExist("ROLE_USER");
            }
            user.setRoles(Collections.singletonList(userRole));
        }

        userRepository.save(user);
    }

    private Role checkRoleExist(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        return roleRepository.save(role);
    }

    public User findByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDTO mapToUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
