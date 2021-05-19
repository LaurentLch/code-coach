package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.CoachInfo;
import com.noobs.codecoach.service.dto.request.CreateCoachInfoDTO;
import com.noobs.codecoach.service.dto.response.CoachInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class CoachInfoMapper {

    public CoachInfo fromDto(CreateCoachInfoDTO createCoachInfoDTO) {
        return new CoachInfo(
                createCoachInfoDTO.getIntroduction(),
                createCoachInfoDTO.getAvailability(),
                createCoachInfoDTO.getCoachTopic()

        );
    }

    public CoachInfoDTO toDto(CoachInfo coachInfo) {
        return new CoachInfoDTO()
                .setId(coachInfo.getId())
                .setAvailability(coachInfo.getAvailability())
                .setIntroduction(coachInfo.getIntroduction())
                .setCoachTopic(coachInfo.getCoachTopic());

    }


}
