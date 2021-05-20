package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.CoachInfo;
import com.noobs.codecoach.service.dto.request.CreateCoachInfoDTO;
import com.noobs.codecoach.service.dto.response.CoachInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CoachInfoMapper {

    private final CoachTopicMapper coachTopicMapper;

    @Autowired
    public CoachInfoMapper(CoachTopicMapper coachTopicMapper) {
        this.coachTopicMapper = coachTopicMapper;
    }

    public CoachInfo fromDto(CreateCoachInfoDTO createCoachInfoDTO) {
        return new CoachInfo(
                createCoachInfoDTO.getIntroduction(),
                createCoachInfoDTO.getAvailability(),
                createCoachInfoDTO.getCoachTopicList()
        );
    }

    public CoachInfoDTO toDto(CoachInfo coachInfo) {
        return new CoachInfoDTO()
                .setId(coachInfo.getId())
                .setAvailability(coachInfo.getAvailability())
                .setIntroduction(coachInfo.getIntroduction())
                .setCoachTopicListDTO(coachInfo.getCoachTopicList().stream().map(coachTopicMapper::toDto).collect(Collectors.toList()));
    }

}
