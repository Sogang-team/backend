package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.FeatureService;
import com.portfolio.portfolio.application.service.StorageService;
import com.portfolio.portfolio.presentation.dto.request.CreateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadFeatureResponse;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "기능 API", description = "기능 정보 API")
public class FeatureController {

    private final FeatureService featureService;
    private final StorageService storageService;

    @Operation(summary = "기능 key값으로 기능 정보를 가져옵니다.", description = "feature의 key값으로 기능 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 자격증 조회 성공", content = @Content(schema = @Schema(implementation = ReadFeatureResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/feature")
    public ResponseEntity<ReadFeatureResponse> getFeatureById(@RequestParam Long featureId) {
        return ResponseEntity.ok(featureService.getById(featureId));
    }

    @Operation(summary = "프로젝트 관련 기능 정보 조회", description = "project key값으로 기능 정보들을 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 자격증 조회 성공", content = @Content(schema = @Schema(implementation = ReadFeatureResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/feature/project")
    public ResponseEntity<List<ReadFeatureResponse>> getFeatureByProjectId(@RequestParam Long projectId) {
        return ResponseEntity.ok(featureService.getByProjectId(projectId));
    }

    @Operation(summary = "기능 생성", description = "프로젝트 id로 관련된 기능을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 자격증 조회 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/feature")
    public ResponseEntity<Long> createFeature(@RequestPart CreateFeatureRequest request, @RequestParam(value = "featureImage", required = false) MultipartFile file) throws IOException {
        return new ResponseEntity<>(featureService.createFeature(request, file), HttpStatus.CREATED);
    }

    @Operation(summary = "기능 제목 변경", description = "feature key값과 제목으로 기능 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/feature/title")
    public ResponseEntity<Void> updateFeatureTitle(@RequestBody UpdateFeatureRequest request) {

        featureService.updateTitle(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "기능 내용 변경", description = "feature key값과 제목으로 기능 내용을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/feature/content")
    public ResponseEntity<Void> updateFeatureContent(@RequestBody UpdateFeatureRequest request) {

        featureService.updateContent(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "기능 이미지 변경", description = "feature key값과 제목으로 기능 이미지를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/feature/image")
    public ResponseEntity<Void> updateFeatureImage(@RequestParam(value = "featureImage") MultipartFile file, @RequestPart UpdateFeatureRequest request) throws IOException {

        if(file != null && !file.isEmpty()) {
            String imageUrl = storageService.uploadFirebaseBucket(file, request.featureTitle());
            featureService.updateImage(request, imageUrl);
        }

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "기능 삭제", description = "기능 key값으로 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "자격증 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @DeleteMapping("/feature")
    public ResponseEntity<Void> deleteFeatureById(@RequestParam Long featureId) {

        featureService.deleteById(featureId);

        return ResponseEntity.noContent().build();
    }
}
