package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.ProjectService;
import com.portfolio.portfolio.presentation.dto.request.CreateProjectRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateProjectRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/project")
    public ResponseEntity<Long> createProject(@RequestPart CreateProjectRequest createProjectRequest, @RequestParam(value = "projectImage", required = false) MultipartFile file) throws IOException {
        return new ResponseEntity<>(projectService.createProject(createProjectRequest, file), HttpStatus.CREATED);
    }

    @PutMapping("/project-title")
    public ResponseEntity<Void> updateProjectTitle(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectTitle(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project-url")
    public ResponseEntity<Void> updateProjectUrl(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectUrl(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project-role")
    public ResponseEntity<Void> updateProjectRole(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectRole(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project-developer-count")
    public ResponseEntity<Void> updateProjectDeveloperCount(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectDeveloperCount(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project-start")
    public ResponseEntity<Void> updateProjectStart(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectStartDate(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project-title")
    public ResponseEntity<Void> updateProjectEnd(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectEndDate(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project-image")
    public ResponseEntity<Void> updateProjectImage(@RequestPart UpdateProjectRequest request ,@RequestParam MultipartFile file) throws IOException {

        projectService.updateRepresentImage(request, file);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/project")
    public ResponseEntity<Void> deleteProject(@RequestParam Long projectId) {

        projectService.deleteProject(projectId);

        return ResponseEntity.noContent().build();
    }
}
