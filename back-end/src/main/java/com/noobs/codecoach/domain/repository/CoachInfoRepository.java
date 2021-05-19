package com.noobs.codecoach.domain.repository;

import com.noobs.codecoach.domain.entity.CoachInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachInfoRepository extends JpaRepository <CoachInfo,Integer> {
}
