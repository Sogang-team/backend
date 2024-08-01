package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private Long featureId;

    @Column(name = "feature_title", nullable = false)
    private String featureTitle;

    @Column(name = "feature_content", nullable = false, columnDefinition = "TEXT")
    private String featureContent;

    @Column(name = "feature_image")
    private String featureImage;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
