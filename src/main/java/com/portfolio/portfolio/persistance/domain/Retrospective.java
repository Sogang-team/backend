package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Builder
    public Retrospective(Long retrospectiveId, String retrospectiveTitle, String retrospectiveContent, Project project) {
        this.retrospectiveId = retrospectiveId;
        this.retrospectiveTitle = retrospectiveTitle;
        this.retrospectiveContent = retrospectiveContent;
        this.project = project;
    }

    public void updateRetrospectiveTitle(String retrospectiveTitle) {
        this.retrospectiveTitle = retrospectiveTitle;
    }

    public void updateRetrospectiveContent(String retrospectiveContent) {
        this.retrospectiveContent = retrospectiveContent;
    }
}
