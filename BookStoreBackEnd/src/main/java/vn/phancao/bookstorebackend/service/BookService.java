package vn.phancao.bookstorebackend.service;

import org.springframework.stereotype.Repository;
import vn.phancao.bookstorebackend.dto.request.BookCreationRequest;
import vn.phancao.bookstorebackend.dto.response.BookCreationResponse;
import vn.phancao.bookstorebackend.dto.response.BookDetailResponse;

import java.util.List;

public interface BookService {
    List<BookDetailResponse> getAllBook();
    BookCreationResponse uploadBook(BookCreationRequest request);
}
