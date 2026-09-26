package com.practice.boundedContext.post.out;

import com.practice.boundedContext.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByOrderByIdDesc();
}
