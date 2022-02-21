package com.example.whateverback.post.model.entity.dto;

import com.example.whateverback.post.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;

    public Post toEntity(){
        return Post.builder()
                .id(this.id)
                .build();
    }
}
