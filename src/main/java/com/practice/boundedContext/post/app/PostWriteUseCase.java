package com.practice.boundedContext.post.app;

import com.practice.boundedContext.member.app.MemberFacade;
import com.practice.boundedContext.member.domain.Member;
import com.practice.boundedContext.post.domain.Post;
import com.practice.boundedContext.post.domain.PostMember;
import com.practice.boundedContext.post.out.PostRepository;
import com.practice.global.eventPublisher.EventPublisher;
import com.practice.global.rsData.RsData;
import com.practice.shared.member.out.MemberApiClient;
import com.practice.shared.post.dto.PostDto;
import com.practice.shared.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostWriteUseCase {
    private final PostRepository postRepository;
    private final EventPublisher eventPublisher;
    private final MemberApiClient memberApiClient;

    public RsData<Post> write(PostMember author, String title, String content) {
        Post post = postRepository.save(new Post(author, title, content));

        eventPublisher.publish(new PostCreatedEvent(new PostDto(post)));

        String randomSecureTip = memberApiClient.getRandomSecureTip();
        return new RsData<>(
                "201-1",
                "%d번 글이 생성되었습니다. 보안 팁 : %s".formatted(post.getId(), randomSecureTip),
                post
        );
    }
}
