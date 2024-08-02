package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.TechStackService;
import com.portfolio.portfolio.persistance.domain.TechStack;
import com.portfolio.portfolio.persistance.domain.UserTech;
import com.portfolio.portfolio.persistance.repository.JpaTechStackRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserTechRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateTechStackRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadTechStackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechStackServiceImpl implements TechStackService {

    private final JpaTechStackRepository techStackRepository;
    private final JpaUserTechRepository userTechRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ReadTechStackResponse> getTechStackByUserId(Long userId) {

        List<ReadTechStackResponse> techStackList = new ArrayList<>();

        List<UserTech> userTechList = userTechRepository.findByUser_userId(userId);

        for(UserTech userTech : userTechList) {
            techStackList.add(ReadTechStackResponse.from(userTech.getTechStack()));
        }

        return techStackList;
    }

    @Transactional
    @Override
    public Long createTechStack(CreateTechStackRequest request) {

        TechStack techStack = techStackRepository.save(request.toEntity());

        return techStack.getTechStackId();
    }

    @Transactional
    @Override
    public void deleteTechStack(Long techStackId) {
        userTechRepository.deleteByTechStack_techStackId(techStackId);
        techStackRepository.deleteById(techStackId);
    }
}