package com.officeparking.office_parking_planner.service.impl;

import org.springframework.stereotype.Service;

import com.officeparking.office_parking_planner.dto.request.RegisterUserRequest;
import com.officeparking.office_parking_planner.dto.response.UserResponse;
import com.officeparking.office_parking_planner.model.entity.User;
import com.officeparking.office_parking_planner.repository.UserRepository;
import com.officeparking.office_parking_planner.service.UserService;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }   

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {
        
        //verify if user already exists
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new RuntimeException("L'utente esiste già");
        }

        //create hashed password with BCrypt
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        //create and save new user
        User user = userRepository.save(new User(
                request.getUsername(),
                encodedPassword,
                request.getFullName()
        ));

        User savedUser = userRepository.save(user);
        
        //return response with user data and success status
        return new UserResponse(
            savedUser.getId(), 
            savedUser.getUsername(), 
            savedUser.getFullName()
        );
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + id));
        return new UserResponse(user.getId(), user.getUsername(), user.getFullName());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getUsername(), user.getFullName()))
                .toList();
    }
}
