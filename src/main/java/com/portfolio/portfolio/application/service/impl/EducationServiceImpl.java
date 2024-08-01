package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.EducationService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Education;
import com.portfolio.portfolio.persistance.domain.UserEducation;
import com.portfolio.portfolio.persistance.repository.JpaEducationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserEducationRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateEducationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateEducationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadEducationResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final JpaEducationRepository educationRepository;
    private final JpaUserEducationRepository userEducationRepository;

    @Transactional(readOnly = true)
    @Override
    public ReadEducationResponse getEducationById(Long educationId) {

        Education education = educationRepository.findById(educationId).orElseThrow(() -> new ApplicationException(
                ErrorStatus.toErrorStatus("해당 교육을 찾을 수 없습니다.", 404, LocalDateTime.now())
        ));

        return ReadEducationResponse.from(education);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadEducationResponse> getEducationByUserId(Long userId) {

        List<ReadEducationResponse> educationList = new ArrayList<>();

        List<UserEducation> userEducationList = userEducationRepository.findByUser_userId(userId);

        for(UserEducation userEducation : userEducationList) {
            educationList.add(ReadEducationResponse.from(userEducation.getEducation()));
        }

        return educationList;
    }

    @Transactional
    @Override
    public Long createEducation(CreateEducationRequest request) {

        Education education = educationRepository.save(request.toEntity());

        return education.getEducationId();
    }

    @Transactional
    @Override
    public void updateEducationTitle(UpdateEducationRequest request) {

        Education education = educationRepository.findById(request.educationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("업데이트 할 교육을 찾지 못했습니다.", 404, LocalDateTime.now())
                ));

        education.updateEducationTitle(request.educationTitle());
    }

    @Transactional
    @Override
    public void updateEducationContent(UpdateEducationRequest request) {

        Education education = educationRepository.findById(request.educationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("업데이트 할 교육을 찾지 못했습니다.", 404, LocalDateTime.now())
                ));

        education.updateEducationContent(request.educationContent());
    }

    @Transactional
    @Override
    public void updateEducationStartDate(UpdateEducationRequest request) {

        Education education = educationRepository.findById(request.educationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("업데이트 할 교육을 찾지 못했습니다.", 404, LocalDateTime.now())
                ));

        education.updateEducationStartDate(request.educationStartDate());
    }

    @Transactional
    @Override
    public void updateEducationEndDate(UpdateEducationRequest request) {

        Education education = educationRepository.findById(request.educationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("업데이트 할 교육을 찾지 못했습니다.", 404, LocalDateTime.now())
                ));

        education.updateEducationEndDate(request.educationEndDate());
    }

    @Transactional
    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
