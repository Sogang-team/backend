package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.EducationService;
import com.portfolio.portfolio.presentation.dto.request.CreateEducationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateEducationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadEducationResponse;
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
@Tag(name = "교육 정보 API", description = "교육 정보 API")
public class EducationController {

    private final EducationService educationService;

    @Operation(summary = "유저 관련 교육 정보 조회", description = "user의 key값으로 유저의 교육 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 교육 조회 성공", content = @Content(schema = @Schema(implementation = ReadEducationResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/education/{userId}")
    public ResponseEntity<List<ReadEducationResponse>> getEducationByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(educationService.getEducationByUserId(userId));
    }

    @Operation(summary = "유저 교육 정보 생성", description = "user의 key값, 교육 정보로 유저의 교육 만듭니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/education/{userId}")
    public ResponseEntity<Long> createEducation(@RequestBody CreateEducationRequest request, @PathVariable Long userId) {
        return new ResponseEntity<>(educationService.createEducation(request,userId), HttpStatus.CREATED);
    }

    @Operation(summary = "교육 제목 변경", description = "자격증 key값과 제목으로 교육 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "제목 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/education-title")
    public ResponseEntity<Void> updateEducationTitle(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationTitle(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "교육 내용 변경", description = "교육 key값과 내용으로 교육 제목을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "내용 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/education-content")
    public ResponseEntity<Void> updateEducationContent(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationContent(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "교육 시작날짜 변경", description = "교육 key값과 날짜로 교육 시작날짜를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "교육 시작날짜 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/education-start-date")
    public ResponseEntity<Void> updateEducationEndDate(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationEndDate(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "교육 종료날짜 변경", description = "교육 key값과 날짜로 교육 종료날짜를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "교육 종료날짜 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/education-end-date")
    public ResponseEntity<Void> updateEducationStartDate(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationStartDate(request);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "교육 삭제", description = "교육 key값으로 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "자격증 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @DeleteMapping("/education")
    public ResponseEntity<Void> deleteEducation(@RequestParam Long educationId) {
        educationService.deleteEducation(educationId);

        return ResponseEntity.noContent().build();
    }
}
