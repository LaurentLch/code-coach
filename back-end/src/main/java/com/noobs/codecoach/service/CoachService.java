package com.noobs.codecoach.service;


import com.noobs.codecoach.domain.entity.Coach;
import com.noobs.codecoach.domain.repository.CoachRepository;
import com.noobs.codecoach.service.dto.request.CreateCoachDTO;
import com.noobs.codecoach.service.dto.response.CoachDTO;
import com.noobs.codecoach.service.mapper.CoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoachService {

    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;

    @Autowired
    public CoachService(CoachRepository coachRepository, CoachMapper coachMapper) {
        this.coachRepository = coachRepository;
        this.coachMapper = coachMapper;
    }

   public CoachDTO createCoach(CreateCoachDTO createCoachDTO){
       Coach coach = coachMapper.fromDto(createCoachDTO);
       Coach createdCoach = coachRepository.save(coach);
       return coachMapper.toDto(createdCoach);


   }


}
