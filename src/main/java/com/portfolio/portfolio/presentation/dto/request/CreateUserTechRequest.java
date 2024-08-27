package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.TechStack;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserTech;
import lombok.Builder;

@Builder
public record CreateUserTechRequest(
        Long userId,
        Long techStackId
) {
    public UserTech toEntity(User user, TechStack techStack) {
        return UserTech.builder()
                .user(user)
                .techStack(techStack)
                .build();
    }
}
