package com.example.whateverback.category.repository;

import com.example.whateverback.category.model.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Long> {

    @Query("SELECT distinct name FROM Industry")
    List<String> findAllName();

    List<Industry> findByMidName(String midName);

    List<Industry> findByName(String name);

}
