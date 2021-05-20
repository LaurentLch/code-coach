package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.CoachInfo;
import com.noobs.codecoach.domain.repository.CoachInfoRepository;
import com.noobs.codecoach.service.dto.request.CreateCoachInfoDTO;
import com.noobs.codecoach.service.dto.response.CoachInfoDTO;
import com.noobs.codecoach.service.mapper.CoachInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoachInfoService {

    private final CoachInfoRepository coachInfoRepository;
    private final CoachInfoMapper coachInfoMapper;

    @Autowired
    public CoachInfoService(CoachInfoRepository coachInfoRepository, CoachInfoMapper coachInfoMapper) {
        this.coachInfoRepository = coachInfoRepository;
        this.coachInfoMapper = coachInfoMapper;
    }

   public CoachInfoDTO createCoachInfo(CreateCoachInfoDTO createCoachInfoDTO){
       CoachInfo coachInfo = coachInfoMapper.fromDto(createCoachInfoDTO);
       CoachInfo createdCoachInfo = coachInfoRepository.save(coachInfo);
       return coachInfoMapper.toDto(createdCoachInfo);
   }

}
