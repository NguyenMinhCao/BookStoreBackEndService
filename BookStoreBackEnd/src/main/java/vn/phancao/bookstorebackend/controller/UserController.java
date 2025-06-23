package vn.phancao.bookstorebackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.phancao.bookstorebackend.dto.response.ResponseData;
import vn.phancao.bookstorebackend.dto.response.UserDetailResponse;
import vn.phancao.bookstorebackend.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    ResponseData<List<UserDetailResponse>> getAll() {
        var result = this.userService.getAllUser();

        return ResponseData.<List<UserDetailResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Get All User")
                .data(result)
                .build();
    }
}
