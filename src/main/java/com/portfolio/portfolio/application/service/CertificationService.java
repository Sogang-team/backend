package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateCertificationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateCertificationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadCertificationResponse;

import java.util.List;

public interface CertificationService {
    ReadCertificationResponse getCertificationById(Long certificationId);
    List<ReadCertificationResponse> getCertificationByUserId(Long userId);
    Long createCertification(CreateCertificationRequest request);
    void updateCertificationName(UpdateCertificationRequest request);
    void updateEducationContent(UpdateCertificationRequest request);
    void updateEducationDate(UpdateCertificationRequest request);
    void deleteCertification(Long id);
}
