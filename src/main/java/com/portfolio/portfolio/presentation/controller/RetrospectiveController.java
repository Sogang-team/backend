package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.RetrospectiveService;
import com.portfolio.portfolio.presentation.dto.request.CreateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadRetrospectiveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RetrospectiveController {

    private final RetrospectiveService retrospectiveService;

    @PostMapping("/retrospective")
    public ResponseEntity<Long> createRetrospective(@RequestBody CreateRetrospectiveRequest createRetrospectiveRequest) {
        return new ResponseEntity<>(retrospectiveService.createRetrospective(createRetrospectiveRequest), HttpStatus.CREATED);
    }

    @GetMapping("/retrospective")
    public ResponseEntity<ReadRetrospectiveResponse> getRetrospective(@RequestParam Long retrospectiveId) {
        return ResponseEntity.ok(retrospectiveService.getRetrospectiveById(retrospectiveId));
    }

    @GetMapping("/retrospective-project")
    public ResponseEntity<List<ReadRetrospectiveResponse>> readRetrospective(@RequestParam Long projectId) {
        return ResponseEntity.ok(retrospectiveService.getRetrospectiveByProjectId(projectId));
    }

    @PutMapping("/retrospective-title")
    public ResponseEntity<Void> updateTitle(@RequestBody UpdateRetrospectiveRequest updateRetrospectiveRequest) {
        retrospectiveService.updateRetrospectiveTitle(updateRetrospectiveRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/retrospective-content")
    public ResponseEntity<Void> updateContent(@RequestBody UpdateRetrospectiveRequest updateRetrospectiveRequest) {
        retrospectiveService.updateRetrospectiveContent(updateRetrospectiveRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/retrospective")
    public ResponseEntity<Void> deleteRetrospective(@RequestParam Long retrospectiveId) {
        retrospectiveService.deleteRetrospectiveById(retrospectiveId);

        return ResponseEntity.noContent().build();
    }
}
