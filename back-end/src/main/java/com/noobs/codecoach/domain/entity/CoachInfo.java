package com.noobs.codecoach.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "coach_info")
public class CoachInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "introduction")
    private String introduction;
    @Column(name = "availability")
    private String availability;
    @Column(name = "coach_topic")
    private String coachTopic; //<- to fix


    public CoachInfo() {
    }


    public CoachInfo(String introduction, String availability, String coachTopic) {
        this.introduction = introduction;
        this.availability = availability;
        this.coachTopic = coachTopic;
    }

    public Integer getId() {
        return id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCoachTopic() {
        return coachTopic;
    }
}
