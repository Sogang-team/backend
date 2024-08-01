package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.EducationService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Education;
import com.portfolio.portfolio.persistance.repository.JpaEducationRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateEducationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateEducationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadEducationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final JpaEducationRepository jpaEducationRepository;

    @Override
    public ReadEducationResponse getEducationById(Long educationId) {

        Education education = jpaEducationRepository.findById(educationId).orElseThrow(() -> new ApplicationException(
                ErrorStatus.toErrorStatus("해당 교육을 찾을 수 없습니다.", 404, LocalDateTime.now())
        ));

        return ReadEducationResponse.from(education);
    }

    @Override
    public Long createEducation(CreateEducationRequest request) {

        Education education = jpaEducationRepository.save(request.toEntity());

        return education.getEducationId();
    }

    @Override
    public void updateEducation(UpdateEducationRequest request) {

    }

    @Override
    public void deleteEducation(Long id) {
        jpaEducationRepository.deleteById(id);
    }
}
