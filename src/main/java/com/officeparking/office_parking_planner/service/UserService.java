package com.officeparking.office_parking_planner.service;

import com.officeparking.office_parking_planner.dto.request.RegisterUserRequest;
import com.officeparking.office_parking_planner.dto.response.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest request);
    
}
