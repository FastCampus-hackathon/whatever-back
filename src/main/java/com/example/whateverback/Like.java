package com.example.whateverback;

import com.example.whateverback.member.model.entity.User;
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
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //찜번호
    @ManyToOne
    @JoinColumn(name= "")
    private User userId; //사용자 번호
    @ManyToOne
    @JoinColumn(name= "")
    private Post postId; //공고 번호
    @ManyToOne
    @JoinColumn(name= "")
    private Group id2; //그룹 번호

}
