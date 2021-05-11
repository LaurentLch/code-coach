package com.noobs.codecoach.service.dto.response;

public class MemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public MemberDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public MemberDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public MemberDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MemberDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MemberDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
