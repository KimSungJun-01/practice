package com.practice.shared.market.event;

import com.practice.shared.market.dto.MarketMemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MarketMemberCreatedEvent {
    private final MarketMemberDto member;
}
