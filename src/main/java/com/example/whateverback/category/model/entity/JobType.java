package com.example.whateverback.category.model.entity;

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
public class JobType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //근무 형태 번호

    @Column(nullable = false, name = "job_type_cd")
    private Long jobTypeCd; //코드

    @Column(nullable = false, name = "job_type_name")
    private String jobTypeName; //근무 형태명

}
