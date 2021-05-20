package com.noobs.codecoach.service.dto.response;

import java.util.List;

public class CoachInfoDTO {

    private int id;
    private String introduction;
    private String availability;
    private List<CoachTopicDTO> coachTopicListDTO;

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

    public List<CoachTopicDTO> getCoachTopicListDTO() {
        return coachTopicListDTO;
    }

    public CoachInfoDTO setCoachTopicListDTO(List<CoachTopicDTO> coachTopicListDTO) {
        this.coachTopicListDTO = coachTopicListDTO;
        return this;
    }
}
