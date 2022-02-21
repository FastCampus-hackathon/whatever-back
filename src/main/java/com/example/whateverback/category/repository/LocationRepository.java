package com.example.whateverback.category.repository;

import com.example.whateverback.category.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT name FROM Location WHERE locMcd = locCd")
    List<String> findFirstLocation();

    Location findByName(String name);

    List<Location> findByLocMcd(Long locMcd);
}
