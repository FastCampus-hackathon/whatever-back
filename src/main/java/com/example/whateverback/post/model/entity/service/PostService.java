package com.example.whateverback.post.model.entity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class PostService {

    private final String OpenUrl = "https://oapi.saramin.co.kr/job-search?access-key=ijkSv7TGoJUUscgWEezwpUZ31ls9FKFUkjH1ji18LzKBdeWTJcE&keyword=IT";

    public ResponseEntity<Map> requestPost() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        headers.set("Access-key", "ijkSv7TGoJUUscgWEezwpUZ31ls9FKFUkjH1ji18LzKBdeWTJcE");
//        headers.set("Access-Controll-Allow-Origin", )

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(OpenUrl).build();

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);

        System.out.println("리턴..");
        return resultMap;
    }
}
