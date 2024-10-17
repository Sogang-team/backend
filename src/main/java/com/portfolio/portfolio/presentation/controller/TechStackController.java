package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.TechStackService;
import com.portfolio.portfolio.presentation.dto.request.CreateTechStackRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadTechStackResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "기술스택 API", description = "기술 스택 API")
public class TechStackController {

    private final TechStackService techStackService;

    @Operation(summary = "유저 기술 스택 조회", description = "유저의 기술 스택들을 불러옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "기술 스택 조회 성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/tech-stack/{userId}")
    public ResponseEntity<List<ReadTechStackResponse>> readTechStack(@PathVariable Long userId) {

        return ResponseEntity.ok(techStackService.getTechStackByUserId(userId));
    }

    @Operation(summary = "유저 기술 스택 생성", description = "유저 id와 기술 스택을 받아 생성합니다..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "기술스택 생성 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/tech-stack/{userId}")
    public ResponseEntity<Long> createTechStack(@RequestBody CreateTechStackRequest request, @PathVariable Long userId, @RequestParam(name = "techStackImage", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(techStackService.createTechStack(request, file, userId));
    }

    @Operation(summary = "기술스택 삭제", description = "기술스택 key값으로 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "기술스택 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @DeleteMapping("/tech-stack")
    public ResponseEntity<Void> deleteTechStack(@RequestParam Long techStackId) {

        techStackService.deleteTechStack(techStackId);

        return ResponseEntity.noContent().build();
    }
}
