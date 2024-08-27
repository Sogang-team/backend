package com.portfolio.portfolio.application.service;

import com.portfolio.portfolio.presentation.dto.request.CreateUserRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateUserRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadUserResponse;

public interface UserService {
    ReadUserResponse getUserById(Long userId);
    Long createUser(CreateUserRequest createUserRequest);
    void updateUserName(UpdateUserRequest updateUserRequest);
    void updateUserEnglishName(UpdateUserRequest updateUserRequest);
    void updateUserBirth(UpdateUserRequest updateUserRequest);
    void updateUserImage(UpdateUserRequest updateUserRequest);
    void updateSimpleIntroduction(UpdateUserRequest updateUserRequest);
    void updateWork(UpdateUserRequest updateUserRequest);
    void updateGithub(UpdateUserRequest updateUserRequest);
    void updateGmail(UpdateUserRequest updateUserRequest);
    void deleteUser(Long userId);
}
