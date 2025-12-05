package com.officeparking.office_parking_planner.dto.response;

import com.officeparking.office_parking_planner.model.entity.User;

public class UserResponse {
    private Long id;
    private String username;
    private String fullName;

    // costruttore vuoto
    public UserResponse() {
    }

    // costruttore con tutti i campi
    public UserResponse(Long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }

    // costruttore da entità User
    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }


    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
