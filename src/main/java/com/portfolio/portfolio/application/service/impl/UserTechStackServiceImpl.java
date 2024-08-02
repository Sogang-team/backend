package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.UserTechStackService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.TechStack;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.domain.UserTech;
import com.portfolio.portfolio.persistance.repository.JpaTechStackRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserTechRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateUserTechRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserTechStackServiceImpl implements UserTechStackService {

    private final JpaUserTechRepository userTechRepository;
    private final JpaUserRepository userRepository;
    private final JpaTechStackRepository techStackRepository;

    @Transactional
    @Override
    public Long createUserTechStack(CreateUserTechRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        TechStack techStack = techStackRepository.findById(request.techStackId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("테크 스택을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        UserTech userTech = userTechRepository.save(request.toEntity(user, techStack));

        return userTech.getUserTechId();
    }
}
