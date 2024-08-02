package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.TechStack;

public record CreateTechStackRequest(

        String techStackName,

        String techStackImage
) {
    public TechStack toEntity() {
        return TechStack.builder()
                .techStackId(null)
                .techStackName(techStackName)
                .techStackImage(techStackImage)
                .build();
    }
}
