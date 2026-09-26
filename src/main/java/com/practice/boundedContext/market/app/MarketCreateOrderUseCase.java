package com.practice.boundedContext.market.app;

import com.practice.boundedContext.market.domain.Cart;
import com.practice.boundedContext.market.domain.Order;
import com.practice.boundedContext.market.out.OrderRepository;
import com.practice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketCreateOrderUseCase {
    private final OrderRepository orderRepository;

    public RsData<Order> createOrder(Cart cart) {
        Order _order = new Order(cart);

        Order order = orderRepository.save(_order);

        cart.clearItems();

        return new RsData<>(
                "201-1",
                "%d번 주문이 생성되었습니다.".formatted(order.getId()),
                order
        );
    }
}
