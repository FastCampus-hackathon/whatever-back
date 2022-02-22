package com.example.whateverback.like.model.dto;

import com.example.whateverback.like.model.entity.Dibs;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.post.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DibsDTO {

    private Long id;
    private User userId;
    private Post postId;

    public Dibs toEntity(){

        return Dibs.builder()
                .id(this.id)
                .user(this.userId)
                .post(this.postId)
                .build();
    }

}
