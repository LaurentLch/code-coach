package com.noobs.codecoach.service.dto.response;


import java.util.List;

public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private CoachInfoDTO coachInfoDTO;
//    private List<String> trainingClass;


    public int getId() {
        return id;
    }

    public UserDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public String getRole() {
        return role;
    }

    public CoachInfoDTO getCoachInfoDTO() {
        return coachInfoDTO;
    }

    public UserDTO setCoachInfoDTO(CoachInfoDTO coachInfoDTO) {
        this.coachInfoDTO = coachInfoDTO;
        return this;
    }

//    public List<String> getTrainingClass() {
//        return trainingClass;
//    }
//
//    public UserDTO setTrainingClass(List<String> trainingClass) {
//        this.trainingClass = trainingClass;
//        return this;
//    }
}
