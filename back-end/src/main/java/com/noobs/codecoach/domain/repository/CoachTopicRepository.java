package com.noobs.codecoach.domain.repository;

import com.noobs.codecoach.domain.entity.CoachTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachTopicRepository extends JpaRepository <CoachTopic, Integer> {
}
