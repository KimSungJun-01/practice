package com.practice.shared.post.event;

import com.practice.shared.post.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreatedEvent {
    private final PostDto post;
}
