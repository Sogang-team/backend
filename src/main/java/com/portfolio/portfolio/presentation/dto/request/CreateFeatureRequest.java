package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Feature;
import com.portfolio.portfolio.persistance.domain.Project;

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
}
