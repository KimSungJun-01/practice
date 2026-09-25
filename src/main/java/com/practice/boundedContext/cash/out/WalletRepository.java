package com.practice.boundedContext.cash.out;

import com.practice.boundedContext.cash.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
