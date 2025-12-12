package com.officeparking.office_parking_planner.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    
    UserDetails loadUserByUsername(String username);
}
