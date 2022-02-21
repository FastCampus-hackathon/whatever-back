package com.example.whateverback;

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
    @Column(nullable = false)
    private Long job_type_cd; //코드
    @Column(nullable = false)
    private String job_type_name; //근무 형태명

}
