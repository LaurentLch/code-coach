package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.CoachTopic;
import com.noobs.codecoach.domain.repository.CoachTopicRepository;
import com.noobs.codecoach.service.dto.request.CreateCoachTopicDTO;
import com.noobs.codecoach.service.dto.response.CoachTopicDTO;
import com.noobs.codecoach.service.mapper.CoachTopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CoachTopicService {

    private final CoachTopicRepository coachTopicRepository;
    private final CoachTopicMapper coachTopicMapper;

    @Autowired
    public CoachTopicService(CoachTopicRepository coachTopicRepository, CoachTopicMapper coachTopicMapper) {
        this.coachTopicRepository = coachTopicRepository;
        this.coachTopicMapper = coachTopicMapper;
    }

    public CoachTopicDTO createCoachTopic(CreateCoachTopicDTO createCoachTopicDTO) {
        CoachTopic coachTopic = coachTopicMapper.fromDto(createCoachTopicDTO);
        CoachTopic createdCoachTopic = coachTopicRepository.save(coachTopic);
        return coachTopicMapper.toDto(createdCoachTopic);
    }
}
