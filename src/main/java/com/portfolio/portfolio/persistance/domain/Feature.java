package com.portfolio.portfolio.persistance.domain;

import com.portfolio.portfolio.presentation.dto.request.UpdateFeatureRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Builder
    public Feature(Long featureId, String featureTitle, String featureContent, String featureImage, Project project) {
        this.featureId = featureId;
        this.featureTitle = featureTitle;
        this.featureContent = featureContent;
        this.featureImage = featureImage;
        this.project = project;
    }

    public void updateFeatureTitle(UpdateFeatureRequest request) {
        this.featureTitle = request.featureTitle();
    }

    public void updateFeatureContent(UpdateFeatureRequest request) {
        this.featureContent = request.featureContent();
    }

    public void updateFeatureImage(String imageUrl) {
        this.featureImage = imageUrl;
    }
}
