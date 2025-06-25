package vn.phancao.bookstorebackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.phancao.bookstorebackend.dto.request.SignInRequest;
import vn.phancao.bookstorebackend.dto.response.ResponseData;
import vn.phancao.bookstorebackend.dto.response.SignInResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    @PostMapping("/sign-in")
    ResponseData<SignInResponse> signIn(@Valid @RequestBody SignInRequest request) {
        return null;
    }
}
