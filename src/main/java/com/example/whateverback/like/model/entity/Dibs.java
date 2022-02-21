package com.example.whateverback.like.model.entity;

import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.post.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dibs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //찜번호

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user; //사용자 번호

    @ManyToOne
    @JoinColumn(nullable = false, name= "post_id")
    private Post post; //공고 번호

}
