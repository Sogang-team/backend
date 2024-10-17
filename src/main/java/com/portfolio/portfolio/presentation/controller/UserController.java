package com.portfolio.portfolio.presentation.controller;

import com.portfolio.portfolio.application.service.UserService;
import com.portfolio.portfolio.presentation.dto.request.CreateUserRequest;
import com.portfolio.portfolio.presentation.dto.request.UpdateUserRequest;
import com.portfolio.portfolio.presentation.dto.response.ReadUserResponse;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name = "유저 정보 API", description = "유저 정보 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 조회", description = "user의 key값으로 유저 정보를 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content(schema = @Schema(implementation = ReadUserResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<ReadUserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @Operation(summary = "유저 생성", description = "유저 정보를 받아 새로운 유저를 만듭니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "유저 생성 성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PostMapping("/user")
    public ResponseEntity<Long> createUser(@RequestPart CreateUserRequest createUserRequest, @RequestParam(value = "userImage", required = false) MultipartFile file) throws IOException {
        return new ResponseEntity<>(userService.createUser(createUserRequest, file), HttpStatus.CREATED);
    }

    @Operation(summary = "유저 이름 수정", description = "유저 key값과 변경할 이름으로 유저의 이름을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-name")
    public ResponseEntity<Void> updateUserName(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserName(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 영어 이름 수정", description = "유저 key값과 변경할 영어 이름으로 유저의 영어 이름을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-english-name")
    public ResponseEntity<Void> updateUserEnglishName(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserEnglishName(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 생일 수정", description = "유저 key값과 변경할 생일으로 유저의 이름을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-birth")
    public ResponseEntity<Void> updateUserBirth(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateUserBirth(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 직무 수정", description = "유저 key값과 변경할 직무으로 유저의 직무를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-work")
    public ResponseEntity<Void> updateWork(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateWork(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 이미지 수정", description = "유저 key값과 변경할 이미지로 유저의 이미지를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-image")
    public ResponseEntity<Void> updateUserImage(@RequestPart UpdateUserRequest updateUserRequest, @RequestParam(value = "userImage", required = false) MultipartFile file) throws IOException {

        userService.updateUserImage(updateUserRequest, file);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 이름 수정", description = "유저 key값과 변경할 이름으로 유저의 이름을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-git")
    public ResponseEntity<Void> updateUserGit(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateGithub(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 이름 수정", description = "유저 key값과 변경할 이름으로 유저의 이름을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    @PutMapping("/user-gmail")
    public ResponseEntity<Void> updateUserGmail(@RequestBody UpdateUserRequest updateUserRequest) {

        userService.updateGmail(updateUserRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "유저 이름 수정", description = "유저 key값과 변경할 이름으로 유저의 이름을 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 조회 성공", content = @Content),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
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
