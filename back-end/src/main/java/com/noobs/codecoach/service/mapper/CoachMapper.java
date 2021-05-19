package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.Coach;
import com.noobs.codecoach.service.dto.request.CreateCoachDTO;
import com.noobs.codecoach.service.dto.response.CoachDTO;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {

    public Coach fromDto(CreateCoachDTO createCoachDTO) {
        return new Coach(
                createCoachDTO.getFirstName(),
                createCoachDTO.getLastName(),
                createCoachDTO.getEmail(),
                createCoachDTO.getCoachTopic(),
                createCoachDTO.getTrainingClass()

        );
    }

    public CoachDTO toDto(Coach coach){
        return new CoachDTO()
                .setId(coach.getId())
                .setFirstName(coach.getFirstName())
                .setLastName(coach.getLastName())
                .setEmail(coach.getEmail())
                .setTrainingClass(coach.getTrainingClass())
                .setCoachTopic(coach.getCoachTopic());


    }



}
