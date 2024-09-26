package com.portfolio.portfolio.application.service.impl;

import com.portfolio.portfolio.application.service.StorageService;
import com.portfolio.portfolio.application.service.UserService;
import com.portfolio.portfolio.common.exception.ApplicationException;
import com.portfolio.portfolio.common.exception.payload.ErrorStatus;
import com.portfolio.portfolio.persistance.domain.User;
import com.portfolio.portfolio.persistance.repository.JpaUserEducationRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserRepository;
import com.portfolio.portfolio.persistance.repository.JpaUserTechRepository;
import com.portfolio.portfolio.presentation.dto.request.CreateUserRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateUserRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadUserResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JpaUserRepository userRepository;
    private final JpaUserEducationRepository userEducationRepository;
    private final JpaUserTechRepository userTechRepository;
    private final StorageService storageService;

    @Transactional(readOnly = true)
    @Override
    public ReadUserResponse getUserById(Long userId) {

         User user = userRepository.findById(userId).orElseThrow(() -> new ApplicationException(
                ErrorStatus.toErrorStatus("해당하는 유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
        ));

        return ReadUserResponse.from(user);
    }

    @Transactional
    @Override
    public Long createUser(CreateUserRequest createUserRequest, MultipartFile file) throws IOException {

        User user = null;

        if(file != null && !file.isEmpty()) {
            String imageUrl = storageService.uploadFirebaseBucket(file, createUserRequest.toEntity().getUserName());
            CreateUserRequest request = CreateUserRequest.updateImageUrl(createUserRequest, imageUrl);
            user = userRepository.save(request.toEntity());
        } else {
            user = userRepository.save(createUserRequest.toEntity());
        }

        return user.getUserId();
    }

    @Transactional
    @Override
    public void updateUserName(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateName(request.userName());
    }

    @Transactional
    @Override
    public void updateUserEnglishName(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateUserEnglishName(request.userEnglishName());
    }

    @Transactional
    @Override
    public void updateUserBirth(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateBirth(request.userBirth());
    }

    @Transactional
    @Override
    public void updateUserImage(UpdateUserRequest request, MultipartFile file) throws IOException {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        String imageUrl = storageService.uploadFirebaseBucket(file, request.userName() + UUID.randomUUID());

        user.updateImage(imageUrl);
    }

    @Transactional
    @Override
    public void updateSimpleIntroduction(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateSimpleIntroduction(request.simpleIntroduction());
    }

    @Transactional
    @Override
    public void updateWork(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateWork(request.work());
    }

    @Transactional
    @Override
    public void updateGithub(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateGithubLink(request.githubLink());
    }

    @Transactional
    @Override
    public void updateGmail(UpdateUserRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ApplicationException(
                        ErrorStatus.toErrorStatus("유저를 찾을 수 없습니다.", 404, LocalDateTime.now())
                ));

        user.updateGmailLink(request.gmailLink());
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        userEducationRepository.deleteByUser_userId(userId);
        userTechRepository.deleteByUser_userId(userId);
        userRepository.deleteById(userId);
    }


}
