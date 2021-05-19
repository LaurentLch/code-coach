package com.noobs.codecoach.service.dto.request;


public class CreateCoachInfoDTO {

    private String introduction;
    private String availability;
    private String coachTopic; //<- to fix


    public String getIntroduction() {
        return introduction;
    }

    public CreateCoachInfoDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public CreateCoachInfoDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public String getCoachTopic() {
        return coachTopic;
    }

    public CreateCoachInfoDTO setCoachTopic(String coachTopic) {
        this.coachTopic = coachTopic;
        return this;
    }
}
