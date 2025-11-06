package com.codewithmosh.store.carts;

import lombok.*;

import java.math.BigDecimal;

@Data
public class CartItemDto {

    private ProductDto product;
    private Integer quantity;
    private BigDecimal totalPrice;

}
