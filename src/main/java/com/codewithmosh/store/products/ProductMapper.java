package com.codewithmosh.store.products;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    com.codewithmosh.store.products.ProductDto toDto(Product product);

    com.codewithmosh.store.carts.ProductDto toCartResponseDto(Product product);

    Product toEntity(com.codewithmosh.store.products.ProductDto productDto);

    @Mapping(target = "id", ignore = true)
    void update(com.codewithmosh.store.products.ProductDto productDto, @MappingTarget Product product);

}
