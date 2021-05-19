package com.noobs.codecoach.service.dto.response;

public class CoachTopicDTO {

    private int id;
    private String topicName;
    private int experienceLevel;

    public int getId() {
        return id;
    }

    public CoachTopicDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getTopicName() {
        return topicName;
    }

    public CoachTopicDTO setTopicName(String topicName) {
        this.topicName = topicName;
        return this;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public CoachTopicDTO setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
        return this;
    }
}
