package com.example.whateverback.post.model.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

            j.id = Integer.parseInt((String)((HashMap<String, Object>)job).get("id"));
            j.url = (String)((HashMap<String, Object>)job).get("url");
            j.company = (String)((HashMap<String, Object>)(((HashMap<String, Object>)(((HashMap<String, Object>)job).get("company"))).get("detail"))).get("name");

            position position = new position();
            position.location = (String)((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)job).get("position")).get("location")).get("name");
            position.experienceLevel = (String)((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)job).get("position")).get("experience-level")).get("name");
            position.jobName = (String)((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)job).get("position")).get("industry")).get("name");

            j.expiration = (String)((HashMap<String, Object>)job).get("expiration-timestamp");
            j.dDay = (String)((HashMap<String, Object>)job).get("expiration-timestamp");
            j.applyCount = Optional.ofNullable((Integer.parseInt((String)((HashMap<String, Object>)job).get("expiration-timestamp")))).orElse(0);

            postResponseDTO.jobs.add(j);
        }
        return postResponseDTO;
    }
}

class Job {
    public int id;
    public String url;
    public String company;

    public String expiration;
    public String dDay;
    public int applyCount;
}

class position {
    public String location;
    public String experienceLevel;
    public String jobName;
}
