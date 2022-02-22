package com.example.whateverback.like.repository;

import com.example.whateverback.like.model.entity.Tagging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaggingRepository extends JpaRepository<Tagging, Long> {
}
