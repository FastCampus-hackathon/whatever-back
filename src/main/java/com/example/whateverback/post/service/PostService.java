package com.example.whateverback.post.service;

import com.example.whateverback.post.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public String getPosts() {
        String apiURL = "https://oapi.saramin.co.kr/job-search?access-key=DokfmvEJiPUKvncqPxcSLO5ODTq8ZTMNy6nlQC1uAwppKyTsr2fK&ind_cd=109";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiURL, String.class);

        return response.getBody();
    }
}
