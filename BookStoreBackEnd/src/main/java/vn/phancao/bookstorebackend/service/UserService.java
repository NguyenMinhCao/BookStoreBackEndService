package vn.phancao.bookstorebackend.service;

import vn.phancao.bookstorebackend.dto.response.UserDetailResponse;
import vn.phancao.bookstorebackend.model.User;

import java.util.List;

public interface UserService {
    List<UserDetailResponse> getAllUser();
}
