package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.CertificationService;
import com.portfolio.portfolio.presentation.dto.request.*;
import com.portfolio.portfolio.presentation.dto.response.ReadCertificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CertificationController {

    private final CertificationService certificationService;

    @GetMapping("/certification/{userId}")
    public ResponseEntity<List<ReadCertificationResponse>> getCertificationByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(certificationService.getCertificationByUserId(userId));
    }

    @PostMapping("/certification/{userId}")
    public ResponseEntity<Long> createCertification(@RequestBody CreateCertificationRequest request, @PathVariable Long userId) {
        return new ResponseEntity<>(certificationService.createCertification(request, userId), HttpStatus.CREATED);
    }

    @PutMapping("/certification-title")
    public ResponseEntity<Void> updateCertificationTitle(@RequestBody UpdateCertificationRequest request) {

        certificationService.updateCertificationName(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/certification-content")
    public ResponseEntity<Void> updateCertificationContent(@RequestBody UpdateCertificationRequest request) {

        certificationService.updateCertificationContent(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/certification-date")
    public ResponseEntity<Void> updateCertificationDate(@RequestBody UpdateCertificationRequest request) {

        certificationService.updateCertificationDate(request);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/certification")
    public ResponseEntity<Void> deleteEducation(@RequestParam Long certificationId) {
        certificationService.deleteCertification(certificationId);

        return ResponseEntity.noContent().build();
    }
}
