package vn.phancao.bookstorebackend.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

// Cần implements Serializable và override equals/hashCode
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // Lombok tự động tạo equals và hashCode
public class ReviewId implements Serializable {
    private Integer user; // Tên trường phải trùng với tên thuộc tính trong Entity Review (tức là user.id)
    private Integer book; // Tên trường phải trùng với tên thuộc tính trong Entity Review (tức là book.id)
}