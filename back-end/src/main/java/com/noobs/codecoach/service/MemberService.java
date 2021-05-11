package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.Member;
import com.noobs.codecoach.domain.repository.MemberRepository;
import com.noobs.codecoach.service.dto.request.CreateMemberDTO;
import com.noobs.codecoach.service.dto.response.MemberDTO;
import com.noobs.codecoach.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDTO createMember(CreateMemberDTO createMemberDTO) {
        Member member = memberMapper.fromDto(createMemberDTO);
        Member createdMember = memberRepository.save(member);
        return memberMapper.toDto(createdMember);
    }
}
