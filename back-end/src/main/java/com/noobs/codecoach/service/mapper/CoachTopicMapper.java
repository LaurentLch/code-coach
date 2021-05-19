package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.CoachTopic;
import com.noobs.codecoach.service.dto.request.CreateCoachTopicDTO;
import com.noobs.codecoach.service.dto.response.CoachTopicDTO;
import org.springframework.stereotype.Component;

@Component
public class CoachTopicMapper {

    public CoachTopic fromDto(CreateCoachTopicDTO createCoachTopicDTO) {
        return new CoachTopic(
                createCoachTopicDTO.getTopicName(),
                createCoachTopicDTO.getExperienceLevel()
        );
    }

    public CoachTopicDTO toDto(CoachTopic coachTopic) {
        return new CoachTopicDTO()
                .setId(coachTopic.getId())
                .setTopicName(coachTopic.getTopicName())
                .setExperienceLevel(coachTopic.getExperienceLevel());
    }
}
