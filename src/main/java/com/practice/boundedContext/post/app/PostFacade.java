package com.practice.boundedContext.post.app;

import com.practice.boundedContext.member.domain.Member;
import com.practice.boundedContext.post.domain.Post;
import com.practice.boundedContext.post.domain.PostMember;
import com.practice.boundedContext.post.out.PostMemberRepository;
import com.practice.boundedContext.post.out.PostRepository;
import com.practice.global.rsData.RsData;
import com.practice.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostSupport postSupport;
    private final PostSyncMemberUseCase postSyncMemberUseCase;
    private final PostWriteUseCase postWriteUseCase;

    @Transactional
    public PostMember syncMember(MemberDto member) {
        return postSyncMemberUseCase.syncMember(member);
    }

    @Transactional
    public RsData<Post> write(PostMember author, String title, String content) {
        return postWriteUseCase.write(author, title, content);
    }

    @Transactional(readOnly = true)
    public long count() {
        return postSupport.count();
    }

    @Transactional(readOnly = true)
    public Optional<Post> findById(int id) {
        return postSupport.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<PostMember> findMemberByUsername(String username) {
        return postSupport.findMemberByUsername(username);
    }
}