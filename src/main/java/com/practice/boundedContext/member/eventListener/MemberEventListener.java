package com.practice.boundedContext.member.eventListener;

import com.practice.boundedContext.member.entity.Member;
import com.practice.boundedContext.member.service.MemberService;
import com.practice.shared.post.event.PostCommentCreatedEvent;
import com.practice.shared.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

@Component
@RequiredArgsConstructor
public class MemberEventListener {
    private final MemberService memberService;

    @TransactionalEventListener(phase = AFTER_COMMIT)
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(PostCreatedEvent event) {
        Member member = memberService.findById(event.getPost().getAuthorId()).get();

        member.increaseActivityScore(3);
    }

    @TransactionalEventListener(phase = AFTER_COMMIT)
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(PostCommentCreatedEvent event) {
        Member member = memberService.findById(event.getPostComment().getAuthorId()).get();

        member.increaseActivityScore(1);
    }
}
