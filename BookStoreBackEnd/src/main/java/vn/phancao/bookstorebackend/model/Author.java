package vn.phancao.bookstorebackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors") // Tên bảng trong DB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Giúp tạo đối tượng dễ dàng hơn
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng (auto-increment)
    @Column(name = "author_id")
    private Integer id; // Sử dụng Integer thay vì int cho ID có thể null

    @Column(name = "author_name", nullable = false)
    private String name;

    @Lob // Để ánh xạ kiểu TEXT trong MySQL
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "created_at", updatable = false) // Không cho phép cập nhật sau khi tạo
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Quan hệ một-nhiều với Book (một tác giả có nhiều sách)
    // mappedBy chỉ ra trường nào trong Entity Book đang quản lý mối quan hệ này
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    // Các phương thức tiện ích để quản lý quan hệ hai chiều
    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    @PrePersist // Được gọi trước khi một entity được lưu vào DB lần đầu
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // Được gọi trước khi một entity được cập nhật
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}