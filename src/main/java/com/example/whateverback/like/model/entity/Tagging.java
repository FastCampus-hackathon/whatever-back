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
public class Tagging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //그룹핑 번호

    @ManyToOne
    @JoinColumn(nullable = false, name= "tag_id")
    private Tag tag; //공고 번호

    @ManyToOne
    @JoinColumn(nullable = false, name= "post_id")
    private Post post; //공고 번호

    @ManyToOne
    @JoinColumn(nullable = false, name= "dibs_id")
    private Dibs dibs; //공고 번호

}
