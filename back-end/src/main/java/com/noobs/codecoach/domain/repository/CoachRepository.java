package com.noobs.codecoach.domain.repository;

import com.noobs.codecoach.domain.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository <Coach,Integer> {
}
