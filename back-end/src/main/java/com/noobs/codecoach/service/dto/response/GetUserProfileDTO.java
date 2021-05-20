package com.noobs.codecoach.service.dto.response;



import java.util.List;

public class GetUserProfileDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> trainingClass;
    private String role;

    public GetUserProfileDTO() {
    }

    public GetUserProfileDTO(String firstName, String lastName, String email, List<String> trainingClass, String role) {
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



    public GetUserProfileDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public GetUserProfileDTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
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



    public String getRole() {
        return role;
    }
}
