package com.noobs.codecoach.api;

import com.noobs.codecoach.service.CoachInfoService;
import com.noobs.codecoach.service.dto.request.CreateCoachInfoDTO;
import com.noobs.codecoach.service.dto.response.CoachInfoDTO;
import com.noobs.codecoach.service.dto.response.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CoachInfoDTO getCoachInfo(@PathVariable int id) throws IllegalArgumentException {
        return coachInfoService.getCoachInfoById(id);
    }

    }
