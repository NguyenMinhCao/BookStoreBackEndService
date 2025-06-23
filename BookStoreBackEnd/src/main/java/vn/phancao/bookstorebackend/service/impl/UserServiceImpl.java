package vn.phancao.bookstorebackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.phancao.bookstorebackend.dto.response.UserDetailResponse;
import vn.phancao.bookstorebackend.repository.UserRepository;
import vn.phancao.bookstorebackend.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDetailResponse> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDetailResponse.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .fullName(String.format("%s %s", user.getFirstName() , user.getLastName()))
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .toList();
    }
}
