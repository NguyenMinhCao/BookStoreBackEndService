package vn.phancao.bookstorebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book extends AbstractEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "thumbnail", nullable = false, columnDefinition = "TEXT")
    private String thumbnail;

    @Column(name = "book_path", columnDefinition = "TEXT")
    private String bookPath;

    @Column(name = "language")
    private String language;

    @Column(name = "view")
    @ColumnDefault("0")
    private Long views;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User author;

    @Column(name = "published_date")
    private LocalDate publishedDate;
}
