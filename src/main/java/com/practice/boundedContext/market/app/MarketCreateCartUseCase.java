package com.practice.boundedContext.market.app;

import com.practice.boundedContext.market.domain.Cart;
import com.practice.boundedContext.market.domain.MarketMember;
import com.practice.boundedContext.market.out.CartRepository;
import com.practice.boundedContext.market.out.MarketMemberRepository;
import com.practice.global.rsData.RsData;
import com.practice.shared.market.dto.MarketMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketCreateCartUseCase {
    private final MarketMemberRepository marketMemberRepository;
    private final CartRepository cartRepository;

    public RsData<Cart> createCart(MarketMemberDto buyer) {
        MarketMember _buyer = marketMemberRepository.getReferenceById(buyer.getId());

        Cart cart = new Cart(_buyer);
        cartRepository.save(cart);

        return new RsData<>(
                "201-1",
                "장바구니가 생성되었습니다.",
                cart
        );
    }
}
