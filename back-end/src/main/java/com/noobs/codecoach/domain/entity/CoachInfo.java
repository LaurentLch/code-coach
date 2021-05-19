package com.noobs.codecoach.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "coach_info")
public class CoachInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "introduction")
    private String introduction;
    @Column(name = "availability")
    private String availability;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_coach_info_id")
    private List<CoachTopic> coachTopicList;

    public CoachInfo() {
    }

    public CoachInfo(String introduction, String availability, List<CoachTopic> coachTopicList) {
        this.introduction = introduction;
        this.availability = availability;
        this.coachTopicList = coachTopicList;
    }

    public Integer getId() {
        return id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getAvailability() {
        return availability;
    }

    public List<CoachTopic> getCoachTopicList() {
        return coachTopicList;
    }
}
