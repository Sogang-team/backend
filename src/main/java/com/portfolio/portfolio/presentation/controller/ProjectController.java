package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.ProjectService;
import com.portfolio.portfolio.presentation.dto.response.ReadProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/project-user")
    public ResponseEntity<List<ReadProjectResponse>> getProjectByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(projectService.getProjectsByUserId(userId));
    }

    @GetMapping("/project")
    public ResponseEntity<ReadProjectResponse> getProjectById(@RequestParam Long projectId) {
        return ResponseEntity.ok(projectService.getProjectById(projectId));
    }
}
