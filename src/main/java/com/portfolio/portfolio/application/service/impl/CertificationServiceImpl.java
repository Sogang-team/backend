package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.CertificationService;
import com.portfolio.portfolio.application.service.UserCertificationService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Certification;
import com.portfolio.portfolio.persistance.domain.UserCertification;
import com.portfolio.portfolio.persistance.repository.JpaCertificationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserCertificationRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateCertificationRequest;
import com.portfolio.portfolio.presentation.dto.request.CreateUserCertificationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateCertificationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadCertificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService {

    private final JpaCertificationRepository certificationRepository;
    private final JpaUserCertificationRepository userCertificationRepository;
    private final UserCertificationService userCertificationService;

    @Transactional(readOnly = true)
    @Override
    public ReadCertificationResponse getCertificationById(Long certificationId) {

        Certification certification = certificationRepository.findById(certificationId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("일치하는 자격증이 없습니다.", 404, LocalDateTime.now())
                ));

        return ReadCertificationResponse.from(certification);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadCertificationResponse> getCertificationByUserId(Long userId) {

        List<UserCertification> userCertificationList = userCertificationRepository.findByUser_userId(userId);

        return userCertificationList.stream()
                .map(UserCertification::getCertification)
                .map(ReadCertificationResponse::from)
                .toList();
    }

    @Transactional
    @Override
    public Long createCertification(CreateCertificationRequest request, Long userId) {

        Certification certification = certificationRepository.save(request.toEntity());
        userCertificationService.createUserCertification(CreateUserCertificationRequest.from(userId, certification.getCertificationId()));

        return certification.getCertificationId();
    }

    @Transactional
    @Override
    public void updateCertificationName(UpdateCertificationRequest request) {

        Certification certification = certificationRepository.findById(request.certificationId())
                        .orElseThrow(() -> new ApplicationException(
                                ErrorStatus.toErrorStatus("자격증을 찾을 수 없습니다.", 404, LocalDateTime.now())
                        ));

        certification.updateCertificationName(request.certificationName());
    }

    @Transactional
    @Override
    public void updateCertificationContent(UpdateCertificationRequest request) {

        Certification certification = certificationRepository.findById(request.certificationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("자격증을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        certification.updateCertificationContent(request.certificationContent());
    }

    @Transactional
    @Override
    public void updateCertificationDate(UpdateCertificationRequest request) {

        Certification certification = certificationRepository.findById(request.certificationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("자격증을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        certification.updateCertificationDate(request.certificationDate());
    }

    @Transactional
    @Override
    public void deleteCertification(Long id) {
        userCertificationRepository.deleteByCertification_certificationId(id);
        certificationRepository.deleteById(id);
    }
}
