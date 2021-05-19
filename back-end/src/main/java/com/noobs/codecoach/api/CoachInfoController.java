package com.noobs.codecoach.api;

import com.noobs.codecoach.service.CoachInfoService;
import com.noobs.codecoach.service.dto.request.CreateCoachInfoDTO;
import com.noobs.codecoach.service.dto.response.CoachInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(path = "/coach_infos", produces = "application/json")
public class CoachInfoController {

        private final CoachInfoService coachInfoService;

        @Autowired
        public CoachInfoController(CoachInfoService coachInfoService) {
            this.coachInfoService = coachInfoService;
        }

        @PostMapping(consumes = "application/json")
        public CoachInfoDTO createCoachInfo(@RequestBody CreateCoachInfoDTO createCoachInfoDTO) {
            return coachInfoService.createCoachInfo(createCoachInfoDTO);
        }
    }
