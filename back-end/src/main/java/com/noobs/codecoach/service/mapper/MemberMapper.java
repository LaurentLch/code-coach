package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.Member;
import com.noobs.codecoach.service.dto.request.CreateMemberDTO;
import com.noobs.codecoach.service.dto.response.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member fromDto(CreateMemberDTO createMemberDTO) {
        return new Member(
                createMemberDTO.getFirstName(),
                createMemberDTO.getLastName(),
                createMemberDTO.getEmail(),
                createMemberDTO.getPassword()
        );
    }

    public MemberDTO toDto(Member member) {
        return new MemberDTO()
                .setId(member.getId())
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setEmail(member.getEmail())
                .setPassword(member.getPassword());
    }
}
