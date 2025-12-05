package com.officeparking.office_parking_planner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.officeparking.office_parking_planner.dto.request.RegisterUserRequest;
import com.officeparking.office_parking_planner.dto.response.UserResponse;
import com.officeparking.office_parking_planner.service.UserService;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getUserById")
    public ResponseEntity<UserResponse> getUserById(@RequestParam Long id) {
        
        UserResponse response = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getUsers() {

        List<UserResponse> responses = userService.getAllUsers();
        return ResponseEntity.ok(responses);
    }
    

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    
}
