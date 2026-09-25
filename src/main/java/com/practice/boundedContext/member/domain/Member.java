package com.practice.boundedContext.member.domain;

import com.practice.shared.member.domain.SourceMember;
import com.practice.shared.member.dto.MemberDto;
import com.practice.shared.member.event.MemberModifiedEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER_MEMBER")
@Getter
@NoArgsConstructor
public class Member extends SourceMember {
    public Member(String username, String password, String nickname) {
        super(username, password, nickname);
    }

    public int increaseActivityScore(int amount) {
        if (amount == 0) return getActivityScore();

        setActivityScore(getActivityScore() + amount);
        publishEvent(new MemberModifiedEvent(new MemberDto(this)));

        return getActivityScore();
    }
}