package vn.phancao.bookstorebackend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseData<T> {

    private int code;
    private String message;
    private T data;
}
