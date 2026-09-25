package com.practice.shared.member.event;

import com.practice.shared.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberModifiedEvent {
    private final MemberDto member;
}
