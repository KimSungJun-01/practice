package com.practice.boundedContext.cash.app;

import com.practice.boundedContext.cash.domain.CashMember;
import com.practice.boundedContext.cash.out.CashMemberRepository;
import com.practice.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashSyncMemberUseCase {
    private final CashMemberRepository cashMemberRepository;

    public CashMember syncMember(MemberDto member) {
        CashMember cashMember = new CashMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                "",
                member.getNickname(),
                member.getActivityScore()
        );

        return cashMemberRepository.save(cashMember);
    }
}
