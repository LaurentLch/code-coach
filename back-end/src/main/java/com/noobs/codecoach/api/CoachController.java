package com.noobs.codecoach.api;

import com.noobs.codecoach.service.CoachService;
import com.noobs.codecoach.service.dto.request.CreateCoachDTO;
import com.noobs.codecoach.service.dto.response.CoachDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(path = "/coaches", produces = "application/json")
public class CoachController {

        private final CoachService coachService;

        @Autowired
        public CoachController(CoachService coachService) {
            this.coachService = coachService;
        }

        @PostMapping(consumes = "application/json")
        public CoachDTO createCoach(@RequestBody CreateCoachDTO createCoachDTO) {
            return coachService.createCoach(createCoachDTO);
        }
    }
