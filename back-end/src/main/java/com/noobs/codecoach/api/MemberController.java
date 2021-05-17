package com.noobs.codecoach.api;

import com.noobs.codecoach.service.MemberService;
import com.noobs.codecoach.service.dto.request.CreateMemberDTO;
import com.noobs.codecoach.service.dto.response.GetMemberProfileDTO;
import com.noobs.codecoach.service.dto.response.MemberDTO;
import com.noobs.codecoach.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(path = "/members", produces = "application/json")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = "application/json")
    public void createMember(@RequestBody CreateMemberDTO createMemberDTO) {
        memberService.createMember(createMemberDTO);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public GetMemberProfileDTO getMemberProfile(@PathVariable int id) throws IllegalArgumentException {
        return memberService.getMemberById(id);

    }


}
