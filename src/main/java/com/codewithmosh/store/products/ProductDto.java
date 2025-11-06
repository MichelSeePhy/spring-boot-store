package com.codewithmosh.store.products;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private byte categoryId;

}
