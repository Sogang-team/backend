package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Education;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserEducation;
import lombok.Builder;

@Builder
public record CreateUserEducationRequest(
        Long userId,
        Long educationId
) {
    public UserEducation toEntity(Education education, User user) {
        return UserEducation.builder()
                .userEducationId(null)
                .education(education)
                .user(user)
                .build();
    }

    public static CreateUserEducationRequest from(Long educationId, Long userId) {
        return CreateUserEducationRequest.builder()
                .userId(userId)
                .educationId(educationId)
                .build();
    }
}
