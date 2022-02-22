package com.example.whateverback.post.model.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class PostResponseDTO {
    public int count;
    public List<Job> jobs = new ArrayList<>();

    public static PostResponseDTO toDTO(HashMap<String, Object> map) {
        map = (HashMap<String, Object>) map.get("jobs");

        PostResponseDTO postResponseDTO = new PostResponseDTO();

        postResponseDTO.count = (int) map.get("count");

        for(Object job : ((ArrayList) map.get("job"))) {
            Job j = new Job();

            j.title = (String)((HashMap<String, Object>)(((HashMap<String, Object>)job).get("position"))).get("title");
            j.id = Integer.parseInt((String)((HashMap<String, Object>)job).get("id"));
            j.url = (String)((HashMap<String, Object>)job).get("url");
            j.company = (String)((HashMap<String, Object>)(((HashMap<String, Object>)(((HashMap<String, Object>)job).get("company"))).get("detail"))).get("name");

            position position = new position();
            position.location = (String)((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)job).get("position")).get("location")).get("name");
            position.location = position.location.replaceAll("&gt;", "");
            position.experienceLevel = (String)((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)job).get("position")).get("experience-level")).get("name");
            position.jobName = (String)((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)job).get("position")).get("industry")).get("name");

            j.position = position;

            String str = (String)((HashMap<String, Object>)job).get("expiration-timestamp");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(Long.parseLong(str) * 1000);

            Date today = new Date();

            long i = date.getTime() - today.getTime();

            j.expiration = sf.format(date);

            j.dDay = "D-" + i / (24 * 60 * 60 * 1000);
            j.applyCount = Integer.parseInt(Optional.ofNullable((String)((HashMap<String, Object>)job).get("apply-cnt")).orElse("0"));

            postResponseDTO.jobs.add(j);
        }
        return postResponseDTO;
    }
}

class Job {
    public int id;
    public String title;
    public String url;
    public String company;

    public position position;

    public String expiration;
    public String dDay;
    public int applyCount;
}

class position {
    public String location;
    public String experienceLevel;
    public String jobName;
}
