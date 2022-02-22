package com.example.whateverback.post.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequestDTO {
    private String baseUrl = "https://oapi.saramin.co.kr/job-search";
    private String accessKey = "?access-key=" + "DokfmvEJiPUKvncqPxcSLO5ODTq8ZTMNy6nlQC1uAwppKyTsr2fK";
    private String jobMidCd;
    private String jobTypeCd;
    private String locBcd;
    private String locMcd;
    private String indMcd;
    private String indCd;
    private Long start;
    private Long count;
    private String keyword;
    private String sort;

    @Builder
    public String getUrl() {
        return baseUrl + accessKey
                + "&job_mid_cd=" + jobMidCd
                + "&job_type_cd=" + jobTypeCd
                + "&loc_bcd=" + locBcd
                + "&loc_mcd=" + locMcd
                + "&ind_mcd=" + indMcd
                + "&ind_cd=" + indCd
                + "&start=" + start
                + "&count=" + count
                + "&keyword=" + keyword
                + "&sort=" + sort;
    }
}
