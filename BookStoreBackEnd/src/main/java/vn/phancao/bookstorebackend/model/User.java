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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash; // Sẽ lưu trữ mật khẩu đã được mã hóa

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Lob
    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

    @Enumerated(EnumType.STRING) // Lưu trữ enum dưới dạng chuỗi 'CUSTOMER' hoặc 'ADMIN'
    @Column(name = "role", columnDefinition = "ENUM('CUSTOMER', 'ADMIN') DEFAULT 'CUSTOMER'")
    private UserRole role; // Custom Enum cho vai trò

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Quan hệ một-nhiều với Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    // Quan hệ một-nhiều với Review
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    // Quan hệ một-một với ShoppingCart
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ShoppingCart shoppingCart;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = UserRole.CUSTOMER; // Đặt giá trị mặc định nếu không được set
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Enum cho vai trò người dùng
    public enum UserRole {
        CUSTOMER,
        ADMIN
    }
}