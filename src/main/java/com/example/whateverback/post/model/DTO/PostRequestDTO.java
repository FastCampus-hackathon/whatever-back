package com.example.whateverback.post.model.DTO;

import com.example.whateverback.category.repository.IndustryRepository;
import com.example.whateverback.category.repository.JobRepository;
import com.example.whateverback.category.repository.JobTypeRepository;
import com.example.whateverback.category.repository.LocationRepository;
import com.example.whateverback.category.service.IndustryService;
import com.example.whateverback.category.service.JobService;
import com.example.whateverback.category.service.JobTypeService;
import com.example.whateverback.category.service.LocationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public class PostRequestDTO {

    private String jobMidCd;
    private String jobTypeCd ;
    private String locBcd;
    private String locMcd;
    private Long start = 0L;
    private Long count = 10L;
    private String keyword = "";
    private String sort = "";

    public String getUrl(String url, IndustryService industryService, JobService jobService, JobTypeService jobTypeService, LocationService locationService) {
        return url
                + "&job_mid_cd=" + jobService.getJobMidCd(jobMidCd)
                + "&job_type_cd=" + jobTypeService.getJobTypeByName(jobTypeCd)
                + "&loc_bcd=" + locationService.getLocationBcdByName(locBcd)
                + "&loc_mcd=" + locationService.getLocationMcdByName(locMcd)
                + "&start=" + start
                + "&count=" + count
                + "&keyword=" + keyword
                + "&sort=" + sort;
    }
}
