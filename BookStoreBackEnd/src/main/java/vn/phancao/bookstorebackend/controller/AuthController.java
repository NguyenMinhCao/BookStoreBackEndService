package vn.phancao.bookstorebackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.phancao.bookstorebackend.dto.request.SignInRequest;
import vn.phancao.bookstorebackend.dto.response.ResponseData;
import vn.phancao.bookstorebackend.dto.response.SignInResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/sign-in")
    ResponseData<SignInResponse> signIn(@Valid @RequestBody SignInRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        return null;
    }
}
