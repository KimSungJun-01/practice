package com.practice.shared.market.event;

import com.practice.shared.market.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarketOrderPaymentRequestedEvent {
    private final OrderDto order;
    private final long pgPaymentAmount;
}
