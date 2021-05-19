package com.noobs.codecoach.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "coach_topic")
    private String coachTopic; //<- to fix
    @Column(name = "training_class")
    private String trainingClass; //<- to fix


    public Coach() {
    }

    public Coach(String firstName, String lastName, String email, String coachTopic, String trainingClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.coachTopic = coachTopic;
        this.trainingClass = trainingClass;
    }


    public Integer getId() {
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

    public String getCoachTopic() {
        return coachTopic;
    }

    public String getTrainingClass() {
        return trainingClass;
    }
}
