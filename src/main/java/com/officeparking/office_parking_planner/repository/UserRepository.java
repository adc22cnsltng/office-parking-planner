package com.officeparking.office_parking_planner.repository;

import com.officeparking.office_parking_planner.model.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
