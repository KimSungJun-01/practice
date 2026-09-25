package com.practice.boundedContext.cash.app;

import com.practice.boundedContext.cash.domain.CashMember;
import com.practice.boundedContext.cash.domain.Wallet;
import com.practice.boundedContext.cash.out.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashCreateWalletUseCase {
    private final WalletRepository walletRepository;

    public Wallet createWallet(CashMember member) {
        Wallet wallet = new Wallet(member);

        return walletRepository.save(wallet);
    }
}
