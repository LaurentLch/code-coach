package com.noobs.codecoach.domain.repository;

//import static org.junit.jupiter.api.Assertions.*;

import com.noobs.codecoach.domain.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberCreate_ifMemberCreated_returnMembersCountPlusOne() {
        long membersCount = memberRepository.count();
        Member member3 = new Member("FNtest2", "LNtest2", "MAD2@gmail.com", "A2azerty");
        memberRepository.save(member3);
        long membersCountNew = memberRepository.count();
        assertThat(membersCountNew).isEqualTo(membersCount + 1);
    }

    @Test
    void createMember_ifMemberInDatabase_thenReturnInfos() {
        Member member1 = new Member("FNtest1", "LNtest1", "MAD1@gmail.com", "A1azerty");
        memberRepository.save(member1);
        assertThat(member1.getFirstName()).isEqualTo("FNtest1");
        assertThat(member1.getLastName()).isEqualTo("LNtest1");
        assertThat(member1.getEmail()).isEqualTo("MAD1@gmail.com");
        assertThat(member1.getPassword()).isEqualTo("A1azerty");
    }

    @Test
    void findMemberByEmail_ifEmailInDatabase_thenReturnFirstName() {
        Member member2 = new Member("FNtest2", "LNtest2", "MAD2@gmail.com", "A2azerty");
        memberRepository.save(member2);
        assertThat(memberRepository.getMemberByEmail("MAD2@gmail.com").getFirstName()).isEqualTo("FNtest2");
    }

    @Test
    void findMemberById_ifMemberInDatabase_thenReturnId() {
        Member member3 = new Member("FNtest3", "LNtest3", "MAD3@gmail.com", "A3azerty");
        memberRepository.save(member3);
        assertThat(memberRepository.getMemberById(member3.getId()).getId()).isEqualTo(member3.getId());
    }


}
