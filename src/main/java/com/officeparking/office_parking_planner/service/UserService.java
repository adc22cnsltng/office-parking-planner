package com.officeparking.office_parking_planner.service;

import java.util.List;

import com.officeparking.office_parking_planner.dto.request.RegisterUserRequest;
import com.officeparking.office_parking_planner.dto.response.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest request);
    
    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();
}
