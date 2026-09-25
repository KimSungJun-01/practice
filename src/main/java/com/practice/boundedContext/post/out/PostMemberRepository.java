package com.practice.boundedContext.post.out;

import com.practice.boundedContext.post.domain.PostMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostMemberRepository extends JpaRepository<PostMember, Integer> {
}
