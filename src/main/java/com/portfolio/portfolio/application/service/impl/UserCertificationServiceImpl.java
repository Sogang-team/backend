package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.UserCertificationService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Certification;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserCertification;
import com.portfolio.portfolio.persistance.repository.JpaCertificationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserCertificationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateUserCertificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserCertificationServiceImpl implements UserCertificationService {

    private final JpaUserCertificationRepository userCertificationRepository;
    private final JpaUserRepository userRepository;
    private final JpaCertificationRepository certificationRepository;

    @Transactional
    @Override
    public Long createUserCertification(CreateUserCertificationRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        Certification certification = certificationRepository.findById(request.certificationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("자격을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        UserCertification userCertification = userCertificationRepository.save(request.toEntity(user, certification));

        return userCertification.getUserCertificationId();
    }
}
