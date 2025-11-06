package com.codewithmosh.store.carts;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateCartItemRequest {

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Minimum value is 1")
    @Max(value = 100, message = "Max value is 100")
    private Integer quantity;

}
