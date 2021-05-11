package com.noobs.codecoach.api;

import com.noobs.codecoach.service.MemberService;
import com.noobs.codecoach.service.dto.request.CreateMemberDTO;
import com.noobs.codecoach.service.dto.response.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/members", produces = "application/json")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = "application/json")
    public MemberDTO createMember(@RequestBody CreateMemberDTO createMemberDTO) {
        return memberService.createMember(createMemberDTO);
    }
}
