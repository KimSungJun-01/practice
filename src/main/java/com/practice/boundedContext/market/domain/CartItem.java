package com.practice.boundedContext.market.domain;

import com.practice.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "MARKET_CART_ITEM")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartItem extends BaseIdAndTime {
    @ManyToOne(fetch = LAZY)
    private Cart cart;

    @ManyToOne(fetch = LAZY)
    private Product product;
}
