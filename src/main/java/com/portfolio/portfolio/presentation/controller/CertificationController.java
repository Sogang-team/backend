package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.CertificationService;
import com.portfolio.portfolio.presentation.dto.request.*;
import com.portfolio.portfolio.presentation.dto.response.ReadCertificationResponse;
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
@Tag(name = "자격증 정보 API", description = "자격증 정보 API")
public class CertificationController {

    private final CertificationService certificationService;

    @Operation(summary = "유저 관련 자격증 정보 조회", description = "user의 key값으로 유저의 자격증 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 자격증 조회 성공", content = @Content(schema = @Schema(implementation = ReadCertificationResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/certification/{userId}")
    public ResponseEntity<List<ReadCertificationResponse>> getCertificationByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(certificationService.getCertificationByUserId(userId));
    }

    @Operation(summary = "유저 자격증 생성", description = "user의 key값, 자격증 정보로 유저의 자격증을 만듭니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/certification/{userId}")
    public ResponseEntity<Long> createCertification(@RequestBody CreateCertificationRequest request, @PathVariable Long userId) {
        return new ResponseEntity<>(certificationService.createCertification(request, userId), HttpStatus.CREATED);
    }

    @Operation(summary = "자격증 제목 변경", description = "자격증 key값과 제목으로 자격증 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/certification-title")
    public ResponseEntity<Void> updateCertificationTitle(@RequestBody UpdateCertificationRequest request) {

        certificationService.updateCertificationName(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "자격증 내용 변경", description = "자격증 key값과 내용으로 자격증 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "내용 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/certification-content")
    public ResponseEntity<Void> updateCertificationContent(@RequestBody UpdateCertificationRequest request) {

        certificationService.updateCertificationContent(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "자격증 취득일자 변경", description = "자격증 key값과 날짜로 자격증 취득일자를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "취득일자 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/certification-date")
    public ResponseEntity<Void> updateCertificationDate(@RequestBody UpdateCertificationRequest request) {

        certificationService.updateCertificationDate(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "자격증 삭제", description = "자격증 key값으로 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "자격증 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @DeleteMapping("/certification")
    public ResponseEntity<Void> deleteEducation(@RequestParam Long certificationId) {
        certificationService.deleteCertification(certificationId);

        return ResponseEntity.noContent().build();
    }
}
