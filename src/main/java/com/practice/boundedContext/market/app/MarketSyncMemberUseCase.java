package com.practice.boundedContext.market.app;

import com.practice.boundedContext.market.domain.MarketMember;
import com.practice.boundedContext.market.out.MarketMemberRepository;
import com.practice.global.eventPublisher.EventPublisher;
import com.practice.shared.market.dto.MarketMemberDto;
import com.practice.shared.market.event.MarketMemberCreatedEvent;
import com.practice.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketSyncMemberUseCase {
    private final MarketMemberRepository marketMemberRepository;
    private final EventPublisher eventPublisher;

    public MarketMember syncMember(MemberDto member) {
        boolean isNew = !marketMemberRepository.existsById(member.getId());

        MarketMember _member = marketMemberRepository.save(new MarketMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                "",
                member.getNickname(),
                member.getActivityScore()
        ));

        if (isNew) {
            eventPublisher.publish(new MarketMemberCreatedEvent(new MarketMemberDto(_member)));
        }

        return _member;
    }
}
