package vn.phancao.bookstorebackend.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import vn.phancao.bookstorebackend.model.enums.Gender;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class UserDetailResponse {
    private String fullName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private Integer age;

    private LocalDate birthday;

    private Gender gender;
}
