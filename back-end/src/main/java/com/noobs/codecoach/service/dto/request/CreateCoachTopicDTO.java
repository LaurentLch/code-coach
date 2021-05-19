package com.noobs.codecoach.service.dto.request;

public class CreateCoachTopicDTO {

    private String topicName;
    private int experienceLevel;

    public String getTopicName() {
        return topicName;
    }

    public CreateCoachTopicDTO setTopicName(String topicName) {
        this.topicName = topicName;
        return this;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public CreateCoachTopicDTO setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
        return this;
    }
}
