package com.noobs.codecoach.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "coach_topic")
public class CoachTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "experience_level")
    private int experienceLevel;

    public CoachTopic() {
    }

    public CoachTopic(String topicName, int experienceLevel) {
        this.topicName = topicName;
        this.experienceLevel = experienceLevel;
    }

    public Integer getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }
}
