package com.practice.boundedContext.member.app;

import com.practice.boundedContext.member.domain.Member;
import com.practice.boundedContext.member.out.MemberRepository;
import com.practice.global.exception.DomainException;
import com.practice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinUseCase {
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password, String nickname) {
        memberRepository.findByUsername(username).ifPresent(m -> {
            throw new DomainException("409-1", "이미 존재하는 username 입니다.");
        });

        Member member = memberRepository.save(new Member(username, password, nickname));
        return new RsData<>("201-1", "%d번 회원 생성되었습니다.".formatted(member.getId()), member);
    }
}
