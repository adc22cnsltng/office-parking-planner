package com.officeparking.office_parking_planner.service.impl;

import org.springframework.stereotype.Service;

import com.officeparking.office_parking_planner.dto.request.RegisterUserRequest;
import com.officeparking.office_parking_planner.dto.response.UserResponse;
import com.officeparking.office_parking_planner.model.entity.User;
import com.officeparking.office_parking_planner.repository.UserRepository;
import com.officeparking.office_parking_planner.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {
        
        //verifica se l'utente esiste già
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new RuntimeException("L'utente esiste già");
        }

        //calcolo della passwrord hashata con BCrypt
        String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());

        //creazione e salvataggio dell'utente
        User user = userRepository.save(new User(
                request.getUsername(),
                hashedPassword,
                request.getFullName()
        ));

        return new UserResponse(user);
    }
}
