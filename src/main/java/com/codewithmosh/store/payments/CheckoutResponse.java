package com.codewithmosh.store.payments;

import lombok.*;

@AllArgsConstructor
@Data
public class CheckoutResponse {

    private Long orderId;
    private String checkoutUrl;

}
