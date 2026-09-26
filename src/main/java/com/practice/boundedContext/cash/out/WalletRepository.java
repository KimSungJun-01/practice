package com.practice.boundedContext.cash.out;

import com.practice.boundedContext.cash.domain.CashMember;
import com.practice.boundedContext.cash.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Optional<Wallet> findByHolder(CashMember holder);
    Optional<Wallet> findByHolderId(int holderId);
}
