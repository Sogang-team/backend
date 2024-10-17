package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.RetrospectiveService;
import com.portfolio.portfolio.presentation.dto.request.CreateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateRetrospectiveRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadCertificationResponse;
import com.portfolio.portfolio.presentation.dto.response.ReadRetrospectiveResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "회고 정보 API", description = "회고 정보 API")
public class RetrospectiveController {

    private final RetrospectiveService retrospectiveService;

    @Operation(summary = "회고 생성", description = "프로젝트 id와 정보들로 관련된 프로젝트 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 프로젝트 추가 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/retrospective")
    public ResponseEntity<Long> createRetrospective(@RequestBody CreateRetrospectiveRequest createRetrospectiveRequest) {
        return new ResponseEntity<>(retrospectiveService.createRetrospective(createRetrospectiveRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "회고 정보 조회", description = "회고 key값으로 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회고 정보 조회 성공", content = @Content(schema = @Schema(implementation = ReadRetrospectiveResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/retrospective")
    public ResponseEntity<ReadRetrospectiveResponse> getRetrospective(@RequestParam Long retrospectiveId) {
        return ResponseEntity.ok(retrospectiveService.getRetrospectiveById(retrospectiveId));
    }

    @Operation(summary = "프로젝트 관련 회고 정보 조회", description = "프로젝트 id로 관련된 회고 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "프로젝트 회고 조회 성공", content = @Content(schema = @Schema(implementation = ReadCertificationResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/retrospective-project")
    public ResponseEntity<List<ReadRetrospectiveResponse>> readRetrospective(@RequestParam Long projectId) {
        return ResponseEntity.ok(retrospectiveService.getRetrospectiveByProjectId(projectId));
    }


    @Operation(summary = "회고 제목 변경", description = "회고 key값과 제목으로 기능 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/retrospective-title")
    public ResponseEntity<Void> updateTitle(@RequestBody UpdateRetrospectiveRequest updateRetrospectiveRequest) {
        retrospectiveService.updateRetrospectiveTitle(updateRetrospectiveRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "회고 내용 변경", description = "회고 key값과 내용으로 기능 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "내용 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/retrospective-content")
    public ResponseEntity<Void> updateContent(@RequestBody UpdateRetrospectiveRequest updateRetrospectiveRequest) {
        retrospectiveService.updateRetrospectiveContent(updateRetrospectiveRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "회고 삭제", description = "회고 key값으로 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회고 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @DeleteMapping("/retrospective")
    public ResponseEntity<Void> deleteRetrospective(@RequestParam Long retrospectiveId) {
        retrospectiveService.deleteRetrospectiveById(retrospectiveId);

        return ResponseEntity.noContent().build();
    }
}
