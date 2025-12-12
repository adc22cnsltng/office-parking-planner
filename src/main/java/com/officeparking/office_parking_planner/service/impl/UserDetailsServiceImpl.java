package com.officeparking.office_parking_planner.service.impl;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.officeparking.office_parking_planner.model.entity.User;
import com.officeparking.office_parking_planner.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // get user from database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato: " + username));

        // Costruiamo uno UserDetails a partire dalla tua entity
        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());

        builder.password(user.getPasswordHash());  // già codificata BCRYPT
        builder.roles("USER");                     // per ora ruolo fisso
        builder.disabled(Boolean.FALSE.equals(user.getIsEnabled()));

        return builder.build();
    }
}