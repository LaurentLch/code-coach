package com.noobs.codecoach.service.dto.request;

import com.noobs.codecoach.domain.entity.CoachTopic;

import java.util.List;

public class CreateCoachInfoDTO {

    private String introduction;
    private String availability;
    private List<CoachTopic> coachTopicList;


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

    public List<CoachTopic> getCoachTopicList() {
        return coachTopicList;
    }

    public CreateCoachInfoDTO setCoachTopicList(List<CoachTopic> coachTopicList) {
        this.coachTopicList = coachTopicList;
        return this;
    }
}
