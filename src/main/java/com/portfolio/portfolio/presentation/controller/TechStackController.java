package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.TechStackService;
import com.portfolio.portfolio.application.service.UserTechStackService;
import com.portfolio.portfolio.presentation.dto.request.CreateTechStackRequest;
import com.portfolio.portfolio.presentation.dto.request.CreateUserTechRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadTechStackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TechStackController {

    private final TechStackService techStackService;

    @GetMapping("/tech-stack/{userId}")
    public ResponseEntity<List<ReadTechStackResponse>> readTechStack(@PathVariable Long userId) {

        return ResponseEntity.ok(techStackService.getTechStackByUserId(userId));
    }

    @PostMapping("/tech-stack/{userId}")
    public ResponseEntity<Long> createTechStack(@RequestBody CreateTechStackRequest request, @PathVariable Long userId, @RequestParam(name = "techStackImage", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(techStackService.createTechStack(request, file, userId));
    }

    @DeleteMapping("/tech-stack")
    public ResponseEntity<Void> deleteTechStack(@RequestParam Long techStackId) {

        techStackService.deleteTechStack(techStackId);

        return ResponseEntity.noContent().build();
    }
}
