package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateTechStackRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadTechStackResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TechStackService {
    List<ReadTechStackResponse> getTechStackByUserId(Long userId);
    Long createTechStack(CreateTechStackRequest request, MultipartFile file, Long userId) throws IOException;
    void deleteTechStack(Long techStackId);
}
