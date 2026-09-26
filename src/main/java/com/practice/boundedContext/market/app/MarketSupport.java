package com.practice.boundedContext.market.app;

import com.practice.boundedContext.market.domain.Cart;
import com.practice.boundedContext.market.domain.MarketMember;
import com.practice.boundedContext.market.domain.Product;
import com.practice.boundedContext.market.out.CartRepository;
import com.practice.boundedContext.market.out.MarketMemberRepository;
import com.practice.boundedContext.market.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketSupport {
    private final ProductRepository productRepository;
    private final MarketMemberRepository marketMemberRepository;
    private final CartRepository cartRepository;

    public long countProducts() {
        return productRepository.count();
    }

    public Optional<MarketMember> findMemberByUsername(String username) {
        return marketMemberRepository.findByUsername(username);
    }

    public Optional<Cart> findCartByBuyer(MarketMember buyer) {
        return cartRepository.findByBuyer(buyer);
    }

    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }
}
