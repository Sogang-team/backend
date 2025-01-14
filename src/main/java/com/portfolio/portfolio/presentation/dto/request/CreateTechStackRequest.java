package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.TechStack;
import lombok.Builder;

@Builder
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

    public static CreateTechStackRequest updateImage(String imageUrl, CreateTechStackRequest request) {
        return CreateTechStackRequest.builder()
                .techStackName(request.techStackName())
                .techStackImage(imageUrl)
                .build();
    }
}
