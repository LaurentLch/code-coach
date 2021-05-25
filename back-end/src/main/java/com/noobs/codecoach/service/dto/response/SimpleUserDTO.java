package com.noobs.codecoach.service.dto.response;

public class SimpleUserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public int getId() {
        return id;
    }

    public SimpleUserDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SimpleUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SimpleUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SimpleUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SimpleUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public SimpleUserDTO setRole(String role) {
        this.role = role;
        return this;
    }
}
