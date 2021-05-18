package com.noobs.codecoach.service.dto.response;

import com.noobs.codecoach.domain.entity.Role;

import java.util.List;

public class GetUserProfileDTO {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> trainingClass;
    private Role role;

    public GetUserProfileDTO() {
    }

    public GetUserProfileDTO(String firstName, String lastName, String email, List<String> trainingClass, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.trainingClass = trainingClass;
        this.role = role;
    }

    public List<String> getTrainingClass() {
        return trainingClass;
    }

    public GetUserProfileDTO setTrainingClass(List<String> trainingClass) {
        this.trainingClass = trainingClass;
        return this;
    }

    public GetUserProfileDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GetUserProfileDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GetUserProfileDTO setEmail(String email) {
        this.email = email;
        return this;
    }



    public GetUserProfileDTO setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }



    public Role getRole() {
        return role;
    }
}
