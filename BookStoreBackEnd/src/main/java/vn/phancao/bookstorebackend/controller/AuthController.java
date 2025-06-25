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

    public final AuthenticationManager authenticationManager;

    @PostMapping("/sign-in")
    ResponseData<SignInResponse> signIn(@Valid @RequestBody SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        System.out.println(authentication.getPrincipal());
        return null;
    }
}
