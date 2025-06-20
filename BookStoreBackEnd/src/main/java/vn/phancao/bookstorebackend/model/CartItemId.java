package vn.phancao.bookstorebackend.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CartItemId implements Serializable {
    private Integer shoppingCart; // Tên trường phải trùng với tên thuộc tính trong Entity CartItem (tức là shoppingCart.id)
    private Integer book; // Tên trường phải trùng với tên thuộc tính trong Entity CartItem (tức là book.id)
}