package com.practice.boundedContext.post.repository;

import com.practice.boundedContext.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
