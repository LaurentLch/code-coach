package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.Member;
import com.noobs.codecoach.domain.repository.MemberRepository;
import com.noobs.codecoach.service.dto.response.MemberDTO;
import com.noobs.codecoach.service.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    public MemberMapper mapper;
    @Mock
    public MemberRepository repository;
    @InjectMocks
    public MemberService service;

    @Test
    void createMember_givenCreateMemberDto_thenUsesMapperAndRepository() {
        //GIVEN
        when(mapper.fromDto(any())).thenReturn(new Member());
        when(repository.save(any())).thenReturn(new Member());
        when(mapper.toDto(any())).thenReturn(new MemberDTO());
        //WHEN
        service.createMember(any());
        //THEN
        InOrder inOrder = Mockito.inOrder(mapper, repository);
        inOrder.verify(mapper).fromDto(any());
        inOrder.verify(repository).save(any());
        inOrder.verify(mapper).toDto(any());
    }

}
