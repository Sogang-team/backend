package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.FeatureService;
import com.portfolio.portfolio.application.service.StorageService;
import com.portfolio.portfolio.presentation.dto.request.CreateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateFeatureRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadFeatureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureService featureService;
    private final StorageService storageService;

    @GetMapping("/feature")
    public ResponseEntity<ReadFeatureResponse> getFeatureById(@RequestParam Long featureId) {
        return ResponseEntity.ok(featureService.getById(featureId));
    }

    @GetMapping("/feature/project")
    public ResponseEntity<List<ReadFeatureResponse>> getFeatureByProjectId(@RequestParam Long projectId) {
        return ResponseEntity.ok(featureService.getByProjectId(projectId));
    }

    @PostMapping("/feature")
    public ResponseEntity<Long> createFeature(@RequestPart CreateFeatureRequest request, @RequestParam(value = "featureImage", required = false) MultipartFile file) throws IOException {
        return new ResponseEntity<>(featureService.createFeature(request, file), HttpStatus.CREATED);
    }

    @PutMapping("/feature/title")
    public ResponseEntity<Void> updateFeatureTitle(@RequestBody UpdateFeatureRequest request) {

        featureService.updateTitle(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/feature/content")
    public ResponseEntity<Void> updateFeatureContent(@RequestBody UpdateFeatureRequest request) {

        featureService.updateContent(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/feature/image")
    public ResponseEntity<Void> updateFeatureImage(@RequestParam(value = "featureImage") MultipartFile file, @RequestPart UpdateFeatureRequest request) throws IOException {

        if(file != null && !file.isEmpty()) {
            String imageUrl = storageService.uploadFirebaseBucket(file, request.featureTitle());
            featureService.updateImage(request, imageUrl);
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/feature")
    public ResponseEntity<Void> deleteFeatureById(@RequestParam Long featureId) {

        featureService.deleteById(featureId);

        return ResponseEntity.noContent().build();
    }
}
