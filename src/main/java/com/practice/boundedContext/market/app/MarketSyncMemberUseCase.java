package com.practice.boundedContext.market.app;

import com.practice.boundedContext.market.domain.MarketMember;
import com.practice.boundedContext.market.out.MarketMemberRepository;
import com.practice.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketSyncMemberUseCase {
    private final MarketMemberRepository marketMemberRepository;

    public MarketMember syncMember(MemberDto member) {
        MarketMember marketMember = new MarketMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                "",
                member.getNickname(),
                member.getActivityScore()
        );

        return marketMemberRepository.save(marketMember);
    }
}
