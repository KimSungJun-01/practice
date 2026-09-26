package com.practice.boundedContext.market.app;

import com.practice.boundedContext.market.domain.Order;
import com.practice.boundedContext.market.out.OrderRepository;
import com.practice.shared.cash.event.CashOrderPaymentSucceededEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketCompleteOrderPaymentUseCase {
    private final OrderRepository orderRepository;

    public void handle(CashOrderPaymentSucceededEvent event) {
        Order order = orderRepository.findById(event.getOrder().getId()).get();

        order.completePayment();
    }
}
