package com.practice.boundedContext.cash.out;

import com.practice.boundedContext.cash.domain.CashMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CashMemberRepository extends JpaRepository<CashMember, Integer> {
    Optional<CashMember> findByUsername(String username);
}
