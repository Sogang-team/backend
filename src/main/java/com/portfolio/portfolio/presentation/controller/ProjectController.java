package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.ProjectService;
import com.portfolio.portfolio.presentation.dto.request.CreateProjectRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateProjectRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadProjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "프로젝트 정보 API", description = "프로젝트 정보 API")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "userId 값으로 프로젝트 정보를 가져옵니다.", description = "userId값으로 프로젝트 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 자격증 조회 성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/project-user")
    public ResponseEntity<List<ReadProjectResponse>> getProjectByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(projectService.getProjectsByUserId(userId));
    }

    @Operation(summary = "projectId 값으로 프로젝트 정보를 가져옵니다.", description = "projectId로 프로젝트 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 자격증 조회 성공", content = @Content(schema = @Schema(implementation = ReadProjectResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/project")
    public ResponseEntity<ReadProjectResponse> getProjectById(@RequestParam Long projectId) {
        return ResponseEntity.ok(projectService.getProjectById(projectId));
    }

    @Operation(summary = "project 생성", description = "user id와 정보들로 관련된 프로젝트 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 프로젝트 추가 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/project")
    public ResponseEntity<Long> createProject(@RequestPart CreateProjectRequest createProjectRequest, @RequestParam(value = "projectImage", required = false) MultipartFile file) throws IOException {
        return new ResponseEntity<>(projectService.createProject(createProjectRequest, file), HttpStatus.CREATED);
    }

    @Operation(summary = "프로젝트 제목 변경", description = "project key값과 제목으로 기능 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-title")
    public ResponseEntity<Void> updateProjectTitle(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectTitle(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 url 변경", description = "project key값과 링크로 기능 url을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "url 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-url")
    public ResponseEntity<Void> updateProjectUrl(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectUrl(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 역할 변경", description = "project key값과 제목으로 프로젝트 역할을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-role")
    public ResponseEntity<Void> updateProjectRole(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectRole(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 참여 인원 변경", description = "project key값과 참여 인원으로 기능 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-developer-count")
    public ResponseEntity<Void> updateProjectDeveloperCount(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectDeveloperCount(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 시작일 변경", description = "project key값과 날짜로 시작일을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-start")
    public ResponseEntity<Void> updateProjectStart(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectStartDate(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 종료일 변경", description = "project key값과 날짜로 종료일을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-end")
    public ResponseEntity<Void> updateProjectEnd(@RequestBody UpdateProjectRequest request) {

        projectService.updateProjectEndDate(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 이미지 변경", description = "project key값과 이미지로 프로젝트 이미지를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/project-image")
    public ResponseEntity<Void> updateProjectImage(@RequestPart UpdateProjectRequest request ,@RequestParam MultipartFile file) throws IOException {

        projectService.updateRepresentImage(request, file);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "프로젝트 삭제", description = "프로젝트 key값으로 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "자격증 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @DeleteMapping("/project")
    public ResponseEntity<Void> deleteProject(@RequestParam Long projectId) {

        projectService.deleteProject(projectId);

        return ResponseEntity.noContent().build();
    }
}
