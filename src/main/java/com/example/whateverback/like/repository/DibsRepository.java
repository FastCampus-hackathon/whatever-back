package com.example.whateverback.like.repository;

import com.example.whateverback.like.model.entity.Dibs;
import com.example.whateverback.member.model.entity.User;
import com.example.whateverback.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DibsRepository extends JpaRepository<Dibs, Long> {
    Optional<Dibs> findByUserAndPost(User user, Post post);

    Optional<Dibs> findByPost(Post post);
}
