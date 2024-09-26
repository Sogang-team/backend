package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Feature;
import com.portfolio.portfolio.persistance.domain.Project;
import lombok.Builder;

@Builder
public record CreateFeatureRequest(

        String featureTitle,

        String featureContent,

        String featureImage,

        Long projectId
) {
    public Feature toEntity(Project project) {
        return Feature.builder()
                .featureId(null)
                .featureTitle(featureTitle)
                .featureContent(featureContent)
                .featureImage(featureImage)
                .project(project)
                .build();
    }

    public static CreateFeatureRequest updateImage(String imageUrl, CreateFeatureRequest createFeatureRequest) {
        return CreateFeatureRequest.builder()
                .featureTitle(createFeatureRequest.featureTitle())
                .featureContent(createFeatureRequest.featureContent())
                .featureImage(imageUrl)
                .projectId(createFeatureRequest.projectId())
                .build();
    }
}
