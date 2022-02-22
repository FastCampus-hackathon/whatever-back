package com.example.whateverback.post.service;

import com.example.whateverback.category.service.IndustryService;
import com.example.whateverback.category.service.JobService;
import com.example.whateverback.category.service.JobTypeService;
import com.example.whateverback.category.service.LocationService;
import com.example.whateverback.post.Repository.PostRepository;
import com.example.whateverback.post.model.dto.PostRequestDTO;
import com.example.whateverback.post.model.dto.PostResponseDTO;
import com.example.whateverback.post.model.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final IndustryService industryService;
    private final JobService jobService;
    private final JobTypeService jobTypeService;
    private final LocationService locationService;

    @Transactional
    public PostResponseDTO getPosts(PostRequestDTO postRequestDTO) {
        String url = "https://oapi.saramin.co.kr/job-search?access-key=DokfmvEJiPUKvncqPxcSLO5ODTq8ZTMNy6nlQC1uAwppKyTsr2fK";
        String apiURL = postRequestDTO.getUrl(url, industryService, jobService, jobTypeService, locationService);

        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, Object> response = restTemplate.getForObject(apiURL, HashMap.class);

        return PostResponseDTO.toDTO(response);
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
