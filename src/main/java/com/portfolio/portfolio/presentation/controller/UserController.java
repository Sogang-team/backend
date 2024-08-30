package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.UserService;
import com.portfolio.portfolio.presentation.dto.request.CreateUserRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateUserRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ReadUserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/user")
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }

    @PutMapping("/user-name")
    public ResponseEntity<Void> updateUserName(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserName(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-english-name")
    public ResponseEntity<Void> updateUserEnglishName(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserEnglishName(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-birth")
    public ResponseEntity<Void> updateUserBirth(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserBirth(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-work")
    public ResponseEntity<Void> updateWork(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateWork(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-image")
    public ResponseEntity<Void> updateUserImage(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserImage(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-git")
    public ResponseEntity<Void> updateUserGit(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateGithub(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-gmail")
    public ResponseEntity<Void> updateUserGmail(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateGmail(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user-introduction")
    public ResponseEntity<Void> updateUserIntroduction(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateSimpleIntroduction(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
