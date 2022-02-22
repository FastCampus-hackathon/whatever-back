package com.example.whateverback.post.service;

import com.example.whateverback.post.Repository.PostRepository;
import com.example.whateverback.post.model.DTO.PostRequestDTO;
import com.example.whateverback.post.model.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public String getPosts(PostRequestDTO postRequestDTO) {
        String apiURL = postRequestDTO.getUrl();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiURL, String.class);

        return response.getBody();
    }

    @Transactional
    public String getPostById(Long id) {
        String apiURL = "https://oapi.saramin.co.kr/job-search";
        String accessKey = "?access-key=" + "DokfmvEJiPUKvncqPxcSLO5ODTq8ZTMNy6nlQC1uAwppKyTsr2fK";
        String postId = "&id=" + id;
        String url = apiURL + accessKey + postId;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }

    @Transactional
    public void createPost(Long id) {
        postRepository.save(new Post(id));
    }
}
