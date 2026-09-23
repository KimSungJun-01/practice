package com.practice.boundedContext.member.app;

import com.practice.boundedContext.member.domain.Member;
import com.practice.global.exception.DomainException;
import com.practice.boundedContext.member.out.MemberRepository;
import com.practice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberRepository memberRepository;
    private final MemberJoinUseCase memberJoinUseCase;

    @Transactional(readOnly = true)
    public long count() {
        return memberRepository.count();
    }

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        return memberJoinUseCase.join(username, password, nickname);
    }

    @Transactional(readOnly = true)
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<Member> findById(int id) {
        return memberRepository.findById(id);
    }
}
