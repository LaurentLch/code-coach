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
        validateInput(topicName, experienceLevel);
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

    private void validateInput(String topicName, int experienceLevel) {
        if (topicName == null) {
            throw new IllegalArgumentException("Wrong argument provided, topicName is null");
        }
        if (topicName.isEmpty() || topicName.isBlank()) {
            throw new IllegalArgumentException("Wrong argument provided, topicName is empty");
        }

        if (experienceLevel < 1 || experienceLevel > 7) {
            throw new IllegalArgumentException("Invalid input, the experience level can only be a value from 1 to 7");
        }
    }

}
