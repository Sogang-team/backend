package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.FeatureService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Feature;
import com.portfolio.portfolio.persistance.domain.Project;
import com.portfolio.portfolio.persistance.repository.JpaFeatureRepository;
import com.portfolio.portfolio.persistance.repository.JpaProjectRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadFeatureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final JpaFeatureRepository featureRepository;
    private final JpaProjectRepository projectRepository;

    @Transactional(readOnly = true)
    @Override
    public ReadFeatureResponse getById(Long id) {

        return ReadFeatureResponse.from(featureRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 기능을 찾을 수 없습니다.", 404, LocalDateTime.now())
                )));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadFeatureResponse> getByProjectId(Long projectId) {
        return featureRepository.findByProject_projectId(projectId).stream().map(ReadFeatureResponse::from).toList();
    }

    @Transactional
    @Override
    public Long createFeature(CreateFeatureRequest createFeatureRequest) {

        Project project = projectRepository.findById(createFeatureRequest.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        return featureRepository.save(createFeatureRequest.toEntity(project)).getFeatureId();
    }

    @Transactional
    @Override
    public void updateTitle(UpdateFeatureRequest request) {

        Feature feature = featureRepository.findById(request.featureId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 기능을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        feature.updateFeatureTitle(request);
    }

    @Transactional
    @Override
    public void updateContent(UpdateFeatureRequest request) {

        Feature feature = featureRepository.findById(request.featureId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 기능을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        feature.updateFeatureContent(request);
    }

    @Transactional
    @Override
    public void updateImage(UpdateFeatureRequest request, String imageUrl) {

        Feature feature = featureRepository.findById(request.featureId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 기능을 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        feature.updateFeatureImage(imageUrl);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        featureRepository.deleteById(id);
    }
}
