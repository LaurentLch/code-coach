package com.noobs.codecoach.domain.repository;

import com.noobs.codecoach.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    public Member getMemberByEmail(String Email);

    public Member getMemberById(Integer id);

}
