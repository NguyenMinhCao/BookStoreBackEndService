package vn.phancao.bookstorebackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.phancao.bookstorebackend.dto.request.BookCreationRequest;
import vn.phancao.bookstorebackend.dto.response.BookCreationResponse;
import vn.phancao.bookstorebackend.dto.response.BookDetailResponse;
import vn.phancao.bookstorebackend.dto.response.ResponseData;
import vn.phancao.bookstorebackend.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    ResponseData<List<BookDetailResponse>> getAllBook() {
        var result = bookService.getAllBook();

        return ResponseData.<List<BookDetailResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Get all book")
                .data(result)
                .build();
    }

    @PostMapping("/upload-books")
    ResponseData<BookCreationResponse> uploadBook(@Valid @RequestBody BookCreationRequest request) {
        var result = this.bookService.uploadBook(request);

        return ResponseData.<BookCreationResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Created user")
                .data(result)
                .build();
    }
}
