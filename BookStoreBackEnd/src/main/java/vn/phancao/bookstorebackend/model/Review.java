package vn.phancao.bookstorebackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(ReviewId.class) // Sử dụng lớp ID tổng hợp cho khóa chính kép
public class Review {

    @Id // Đánh dấu là một phần của khóa chính kép
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Id // Đánh dấu là một phần của khóa chính kép
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Book book;

    @Column(name = "rating", nullable = false)
    private Integer rating; // CHECK (rating >= 1 AND rating <= 5) sẽ được thực thi ở DB

    @Lob
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "review_date", nullable = false, updatable = false)
    private LocalDateTime reviewDate;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.reviewDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}