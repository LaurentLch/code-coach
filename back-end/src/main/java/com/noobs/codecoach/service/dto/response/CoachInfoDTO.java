package com.noobs.codecoach.service.dto.response;

public class CoachInfoDTO {

    private int id;
    private String introduction;
    private String availability;
    private String coachTopic; //<- to fix

    public int getId() {
        return id;
    }

    public CoachInfoDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public CoachInfoDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public CoachInfoDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public String getCoachTopic() {
        return coachTopic;
    }

    public CoachInfoDTO setCoachTopic(String coachTopic) {
        this.coachTopic = coachTopic;
        return this;
    }
}
