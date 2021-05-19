package com.noobs.codecoach.service.dto.request;


public class CreateCoachDTO {


    private String firstName;
    private String lastName;
    private String email;
    private String CoachTopic; //<- to fix
    private String trainingClass; //<- to fix


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCoachTopic() {
        return CoachTopic;
    }

    public String getTrainingClass() {
        return trainingClass;
    }

    public CreateCoachDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateCoachDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateCoachDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateCoachDTO setCoachTopic(String coachTopic) {
        CoachTopic = coachTopic;
        return this;
    }

    public CreateCoachDTO setTrainingClass(String trainingClass) {
        this.trainingClass = trainingClass;
        return this;
    }
}
