package vn.phancao.bookstorebackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.phancao.bookstorebackend.dto.request.BookCreationRequest;
import vn.phancao.bookstorebackend.dto.response.BookCreationResponse;
import vn.phancao.bookstorebackend.dto.response.BookDetailResponse;
import vn.phancao.bookstorebackend.model.Book;
import vn.phancao.bookstorebackend.model.User;
import vn.phancao.bookstorebackend.repository.BookRepository;
import vn.phancao.bookstorebackend.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDetailResponse> getAllBook() {
        return bookRepository.findAll().stream()
                .map(book -> BookDetailResponse.builder()
                        .id(book.getId())
                        .isbn(book.getIsbn())
                        .price(book.getPrice())
                        .title(book.getTitle())
                        .stock(book.getStock())
                        .views(book.getViews())
                        .description(book.getDescription())
                        .publishedDate(book.getPublishedDate())
                        .language(book.getLanguage())
                        .publisher(book.getPublisher())
                        .thumbnail(book.getThumbnail())
                        .build())
                .toList();
    }

    @Override
    public BookCreationResponse uploadBook(BookCreationRequest request) {
        User user = new User();
        user.setId(11L);

        Book book = Book.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .description(request.getDescription())
                .price(request.getPrice())
                .language(request.getLanguage())
                .thumbnail("thumbnailUrl")
                .bookPath("bookPath")
                .author(user)
                .publisher("user.getEmail()")
                .build();

        bookRepository.save(book);

        return BookCreationResponse.builder()
                .authorName(user.getFullName())
                .price(book.getPrice())
                .title(book.getTitle())
                .language(book.getLanguage())
                .bookPath(book.getBookPath())
                .isbn(book.getIsbn())
                .description(book.getDescription())
                .build();
    }
}
