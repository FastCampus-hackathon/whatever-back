package com.example.whateverback.category.repository;

import com.example.whateverback.category.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT distinct name FROM Job")
    List<String> findAllName();

    Job findMidCdByName(String name);
}
