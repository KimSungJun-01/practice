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
    private final PostRepository postRepository;
    private final PostWriteUseCase postWriteUseCase;
    private final PostMemberRepository postMemberRepository;

    @Transactional(readOnly = true)
    public long count() {
        return postRepository.count();
    }

    @Transactional
    public RsData<Post> write(Member author, String title, String content) {
        return postWriteUseCase.write(author, title, content);
    }

    @Transactional(readOnly = false)
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    @Transactional
    public PostMember syncMember(MemberDto member) {
        PostMember _member = new PostMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                "",
                member.getNickname(),
                member.getActivityScore()
        );

        return postMemberRepository.save(_member);
    }
}
