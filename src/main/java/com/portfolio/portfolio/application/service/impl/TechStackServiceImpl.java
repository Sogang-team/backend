package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.StorageService;
import com.portfolio.portfolio.application.service.TechStackService;
import com.portfolio.portfolio.application.service.UserTechStackService;
import com.portfolio.portfolio.persistance.domain.TechStack;
import com.portfolio.portfolio.persistance.domain.UserTech;
import com.portfolio.portfolio.persistance.repository.JpaTechStackRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserTechRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateTechStackRequest;
import com.portfolio.portfolio.presentation.dto.request.CreateUserTechRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadTechStackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechStackServiceImpl implements TechStackService {

    private final JpaTechStackRepository techStackRepository;
    private final JpaUserTechRepository userTechRepository;
    private final StorageService storageService;
    private final UserTechStackService userTechStackService;

    @Transactional(readOnly = true)
    @Override
    public List<ReadTechStackResponse> getTechStackByUserId(Long userId) {

        List<UserTech> userTechList = userTechRepository.findByUser_userId(userId);

        return userTechList.stream()
                .map(UserTech::getTechStack)
                .map(ReadTechStackResponse::from)
                .toList();
    }

    @Transactional
    @Override
    public Long createTechStack(CreateTechStackRequest request, MultipartFile file, Long userId) throws IOException {

        TechStack techStack = null;

        if(!file.isEmpty() && file != null) {
            String imageUrl = storageService.uploadFirebaseBucket(file, request.techStackName());
            CreateTechStackRequest createTechStackRequest = CreateTechStackRequest.updateImage(imageUrl, request);
            techStack = techStackRepository.save(createTechStackRequest.toEntity());
        } else {
            techStack = techStackRepository.save(request.toEntity());
        }

        userTechStackService.createUserTechStack(CreateUserTechRequest.from(userId, techStack.getTechStackId()));

        return techStack.getTechStackId();
    }

    @Transactional
    @Override
    public void deleteTechStack(Long techStackId) {
        userTechRepository.deleteByTechStack_techStackId(techStackId);
        techStackRepository.deleteById(techStackId);
    }
}
