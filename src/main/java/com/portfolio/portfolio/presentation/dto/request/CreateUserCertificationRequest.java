package com.portfolio.portfolio.presentation.dto.request;

import com.portfolio.portfolio.persistance.domain.Certification;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserCertification;
import lombok.Builder;

@Builder
public record CreateUserCertificationRequest(

        Long userId,

        Long certificationId

) {
    public UserCertification toEntity(User user, Certification certification) {
        return UserCertification.builder()
                .userCertificationId(null)
                .user(user)
                .certification(certification)
                .build();
    }
}
