package com.codewithmosh.store.payments;

import com.codewithmosh.store.auth.AuthService;
import com.codewithmosh.store.carts.*;
import com.codewithmosh.store.orders.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.codewithmosh.store.orders.Order.fromCart;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CartRepository cartRepository;
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final PaymentGateway paymentGateway;

    @Transactional
    public CheckoutResponse checkout(CheckoutRequest request) {
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }

        var order = fromCart(cart, authService.getCurrentUser());
        orderRepository.save(order);

        try {

            var session = paymentGateway.createCheckoutSession(order);

            cartService.clearCart(cart.getId());


            return new CheckoutResponse(order.getId(), session.getCheckoutUlr());
        } catch (PaymentException ex) {
            System.out.println(ex.getMessage());
            orderRepository.delete(order);
            throw ex;
        }
    }

    public void handleWebhookEvent(WebhookRequest webhookRequest) {
        paymentGateway
                .parseWebhookRequest(webhookRequest)
                .ifPresent(paymentResult -> {
                    var order = orderRepository.findById(paymentResult.getOrderId()).orElseThrow();
                    order.setStatus(paymentResult.getPaymentStatus());
                    orderRepository.save(order);
                });


    }
}
