package com.codewithmosh.store.orders;


import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    OrderDto toDto(Order order);
}
