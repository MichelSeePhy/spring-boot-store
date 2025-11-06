package com.codewithmosh.store.payments;

import com.codewithmosh.store.orders.PaymentStatus;
import lombok.*;

@AllArgsConstructor
@Getter
public class PaymentResult {

    private Long orderId;
    private PaymentStatus paymentStatus;

}
