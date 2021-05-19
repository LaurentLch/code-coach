package com.noobs.codecoach.api;

import com.noobs.codecoach.service.CoachTopicService;
import com.noobs.codecoach.service.dto.request.CreateCoachTopicDTO;
import com.noobs.codecoach.service.dto.response.CoachTopicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(path = "/coach-topics", produces = "application/json")
public class CoachTopicController {

    private final CoachTopicService coachTopicService;

    @Autowired
    public CoachTopicController(CoachTopicService coachTopicService) {
        this.coachTopicService = coachTopicService;
    }

    @PostMapping(consumes = "application/json")
    public CoachTopicDTO createCoachTopic(@RequestBody CreateCoachTopicDTO createCoachTopicDTO) {
        return coachTopicService.createCoachTopic(createCoachTopicDTO);
   }
}
