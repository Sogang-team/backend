package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateUserRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateUserRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadUserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    ReadUserResponse getUserById(Long userId);
    Long createUser(CreateUserRequest createUserRequest, MultipartFile file) throws IOException;
    void updateUserName(UpdateUserRequest updateUserRequest);
    void updateUserEnglishName(UpdateUserRequest updateUserRequest);
    void updateUserBirth(UpdateUserRequest updateUserRequest);
    void updateUserImage(UpdateUserRequest updateUserRequest, MultipartFile file) throws IOException;
    void updateSimpleIntroduction(UpdateUserRequest updateUserRequest);
    void updateWork(UpdateUserRequest updateUserRequest);
    void updateGithub(UpdateUserRequest updateUserRequest);
    void updateGmail(UpdateUserRequest updateUserRequest);
    void deleteUser(Long userId);
}
