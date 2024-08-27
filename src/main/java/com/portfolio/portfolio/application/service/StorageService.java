package com.portfolio.portfolio.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    String uploadFirebaseBucket(MultipartFile multipartFile, String fileName) throws IOException;
    void deleteFirebaseBucket(String key);
}
