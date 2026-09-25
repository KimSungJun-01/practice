package com.practice.boundedContext.post.domain;

import com.practice.shared.member.domain.ReplicaMember;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POST_MEMBER")
@Getter
@NoArgsConstructor
public class PostMember extends ReplicaMember {
    public PostMember(String username, String password, String nickname) {
        super(username, password, nickname);
    }
}
