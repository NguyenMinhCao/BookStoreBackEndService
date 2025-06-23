package vn.phancao.bookstorebackend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BookDetailResponse {
    private String title;

    private String isbn;

    private String description;

    private BigDecimal price;

    private Long stock;

    private String publisher;

    private String thumbnail;

    private String language;

    private Long views;

    private LocalDate publishedDate;
}
