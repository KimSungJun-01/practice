package com.practice.boundedContext.cash.app;

import com.practice.boundedContext.cash.domain.CashMember;
import com.practice.boundedContext.cash.domain.Wallet;
import com.practice.boundedContext.cash.out.CashMemberRepository;
import com.practice.boundedContext.cash.out.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashSupport {
    private final CashMemberRepository cashMemberRepository;
    private final WalletRepository walletRepository;

    public Optional<CashMember> findMemberByUsername(String username) {
        return cashMemberRepository.findByUsername(username);
    }

    public Optional<Wallet> findWalletByHolder(CashMember holder) {
        return walletRepository.findByHolder(holder);
    }
}
