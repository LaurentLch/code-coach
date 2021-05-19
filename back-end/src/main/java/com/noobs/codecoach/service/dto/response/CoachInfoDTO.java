package com.noobs.codecoach.service.dto.response;

import com.noobs.codecoach.domain.entity.CoachTopic;

import java.util.List;

public class CoachInfoDTO {

    private int id;
    private String introduction;
    private String availability;
    private List<CoachTopic> coachTopicList;

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

    public List<CoachTopic> getCoachTopicList() {
        return coachTopicList;
    }

    public CoachInfoDTO setCoachTopicList(List<CoachTopic> coachTopicList) {
        this.coachTopicList = coachTopicList;
        return this;
    }
}
