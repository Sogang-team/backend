package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.RetrospectiveService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.Project;
import com.portfolio.portfolio.persistance.domain.Retrospective;
import com.portfolio.portfolio.persistance.repository.JpaProjectRepository;
import com.portfolio.portfolio.persistance.repository.JpaRetrospectiveRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadRetrospectiveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrospectiveServiceImpl implements RetrospectiveService {

    private final JpaRetrospectiveRepository retrospectiveRepository;
    private final JpaProjectRepository projectRepository;

    @Transactional
    @Override
    public Long createRetrospective(CreateRetrospectiveRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 프로젝트를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        Retrospective retrospective = retrospectiveRepository.save(request.toEntity(project));

        return retrospective.getRetrospectiveId();
    }

    @Transactional
    @Override
    public void updateRetrospectiveTitle(UpdateRetrospectiveRequest request) {

        Retrospective retrospective = retrospectiveRepository.findById(request.retrospectiveId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 회고를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        retrospective.updateRetrospectiveTitle(request.retrospectiveTitle());
    }

    @Transactional
    @Override
    public void updateRetrospectiveContent(UpdateRetrospectiveRequest request) {

        Retrospective retrospective = retrospectiveRepository.findById(request.retrospectiveId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 회고를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        retrospective.updateRetrospectiveContent(request.retrospectiveContent());
    }

    @Transactional(readOnly = true)
    @Override
    public ReadRetrospectiveResponse getRetrospectiveById(Long retrospectiveId) {

        return ReadRetrospectiveResponse.from(retrospectiveRepository.findById(retrospectiveId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("해당 회고를 찾을 수 없습니다.", 404, LocalDateTime.now())
                )));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadRetrospectiveResponse> getRetrospectiveByProjectId(Long projectId) {
        return retrospectiveRepository.findByProject_projectId(projectId).stream().map(ReadRetrospectiveResponse::from).toList();
    }

    @Transactional
    @Override
    public void deleteRetrospectiveById(Long retrospectiveId) {
        retrospectiveRepository.deleteById(retrospectiveId);
    }
}
