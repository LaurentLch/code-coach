package com.noobs.codecoach.service.dto.request;

import com.noobs.codecoach.domain.entity.Role;

public class CreateSimpleUserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role = Role.COACHEE.getRoleName();

    public String getFirstName() {
        return firstName;
    }

    public CreateSimpleUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateSimpleUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateSimpleUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateSimpleUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }
}
