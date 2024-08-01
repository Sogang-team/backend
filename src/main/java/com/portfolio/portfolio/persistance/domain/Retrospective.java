package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "retrospective")
public class Retrospective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retrospective_id")
    private Long retrospectiveId;

    @Column(name = "retrospective_title", nullable = false)
    private String retrospectiveTitle;

    @Column(name = "retrospectiveContent", columnDefinition = "TEXT")
    private String retrospectiveContent;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
