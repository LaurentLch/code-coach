package com.noobs.codecoach.service.dto.response;

public class CoachDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String CoachTopic; //<- to fix
    private String trainingClass; //<- to fix

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public CoachDTO setId(int id) {
        this.id = id;
        return this;
    }

    public CoachDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CoachDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CoachDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCoachTopic() {
        return CoachTopic;
    }

    public CoachDTO setCoachTopic(String coachTopic) {
        CoachTopic = coachTopic;
        return this;
    }

    public String getTrainingClass() {
        return trainingClass;
    }

    public CoachDTO setTrainingClass(String trainingClass) {
        this.trainingClass = trainingClass;
        return this;
    }
}
