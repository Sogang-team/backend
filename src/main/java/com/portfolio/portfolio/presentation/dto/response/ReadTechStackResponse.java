package com.portfolio.portfolio.presentation.dto.response;

import com.portfolio.portfolio.persistance.domain.TechStack;
import lombok.Builder;

@Builder
public record ReadTechStackResponse(
        String techStackName,
        String techStackImage
) {
    public static ReadTechStackResponse from(TechStack techStack) {
        return ReadTechStackResponse.builder()
                .techStackName(techStack.getTechStackName())
                .techStackImage(techStack.getTechStackImage())
                .build();
    }
}
