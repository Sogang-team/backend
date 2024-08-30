package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.Feature;
import lombok.Builder;

@Builder
public record ReadFeatureResponse(

        Long featureId,

        String featureTitle,

        String featureContent,

        String featureImage,

        Long projectId
) {
    public static ReadFeatureResponse from(Feature feature) {
        return ReadFeatureResponse.builder()
                .featureId(feature.getFeatureId())
                .featureTitle(feature.getFeatureTitle())
                .featureContent(feature.getFeatureContent())
                .featureImage(feature.getFeatureImage())
                .projectId(feature.getProject().getProjectId())
                .build();
    }
}
