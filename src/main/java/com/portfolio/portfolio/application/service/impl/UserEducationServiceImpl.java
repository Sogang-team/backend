package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.UserEducationService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Education;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserEducation;
import com.portfolio.portfolio.persistance.repository.JpaEducationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserEducationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateUserEducationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEducationServiceImpl implements UserEducationService {

    private final JpaUserEducationRepository userEducationRepository;
    private final JpaUserRepository userRepository;
    private final JpaEducationRepository educationRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Long> getEducationIdByUserId(Long userId) {

        List<Long> educationIdList = new ArrayList<>();

        List<UserEducation> userEducationList = userEducationRepository.findByUser_userId(userId);

        for (UserEducation userEducation : userEducationList) {
            educationIdList.add(userEducation.getEducation().getEducationId());
        }

        return educationIdList;
    }

    @Transactional
    @Override
    public Long createUserEducation(CreateUserEducationRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        Education education = educationRepository.findById(request.educationId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("교육을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        UserEducation userEducation = userEducationRepository.save(request.toEntity(education, user));

        return userEducation.getUserEducationId();
    }
}
