package com.practice.boundedContext.market.out;

import com.practice.boundedContext.market.domain.MarketMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketMemberRepository extends JpaRepository<MarketMember, Integer> {
    Optional<MarketMember> findByUsername(String username);
}
