package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.EducationService;
import com.portfolio.portfolio.presentation.dto.request.CreateEducationRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateEducationRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadEducationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping("/education/{userId}")
    public ResponseEntity<List<ReadEducationResponse>> getEducationByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(educationService.getEducationByUserId(userId));
    }

    @PostMapping("/education/{userId}")
    public ResponseEntity<Long> createEducation(@RequestBody CreateEducationRequest request, @PathVariable Long userId) {
        return new ResponseEntity<>(educationService.createEducation(request,userId), HttpStatus.CREATED);
    }

    @PutMapping("/education-title")
    public ResponseEntity<Void> updateEducationTitle(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationTitle(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/education-content")
    public ResponseEntity<Void> updateEducationContent(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationContent(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/education-start-date")
    public ResponseEntity<Void> updateEducationEndDate(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationEndDate(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/education-end-date")
    public ResponseEntity<Void> updateEducationStartDate(@RequestBody UpdateEducationRequest request) {

        educationService.updateEducationStartDate(request);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/education")
    public ResponseEntity<Void> deleteEducation(@RequestParam Long educationId) {
        educationService.deleteEducation(educationId);

        return ResponseEntity.noContent().build();
    }
}
