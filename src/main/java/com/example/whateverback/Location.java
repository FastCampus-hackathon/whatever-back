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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //근무지번호
    @Column(nullable = false)
    private Long loc_mcd; //1차 근무지
    @Column(nullable = false)
    private Long loc_bcd; //2차 근무지
    @Column(nullable = false)
    private Long loc_cd; //3차 근무지
    @Column(nullable = false)
    private String name;

}
