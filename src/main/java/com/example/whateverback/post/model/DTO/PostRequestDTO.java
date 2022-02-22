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
    private String jobCd;
    private String jobType;
    private String locCd;
    private String indCd;
    private String page;
    private String count;

    @Builder
    public String getUrl() {
        return baseUrl + accessKey
                + "&job_mid_cd=" + jobMidCd
                + "&job_cd=" + jobCd
                + "&job_type=" + jobType
                + "&loc_cd=" + locCd
                + "&ind_cd=" + indCd
                + "&page=" + page
                + "&count=" + count;
    }
}
