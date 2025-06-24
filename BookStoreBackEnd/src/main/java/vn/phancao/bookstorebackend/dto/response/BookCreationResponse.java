package vn.phancao.bookstorebackend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BookCreationResponse {
    private String authorName;
    private String title;
    private String isbn;
    private String description;
    private BigDecimal price;
    private String language;
    private String thumbnail;
    private String bookPath;
}
