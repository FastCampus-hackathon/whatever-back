package com.example.whateverback.category.repository;

import com.example.whateverback.category.model.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
