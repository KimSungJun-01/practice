package com.practice.boundedContext.post.app;

import com.practice.boundedContext.member.domain.Member;
import com.practice.boundedContext.post.domain.Post;
import com.practice.boundedContext.post.out.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;
    private final PostWriteUseCase postWriteUseCase;

    @Transactional(readOnly = true)
    public long count() {
        return postRepository.count();
    }

    @Transactional
    public Post write(Member author, String title, String content) {
        return postWriteUseCase.write(author, title, content);
    }

    @Transactional(readOnly = false)
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}
