package com.portfolio.portfolio.presentation.dto.request;

public record UpdateFeatureRequest(

        Long featureId,

        String featureTitle,

        String featureContent,

        String featureImage
) {
}
