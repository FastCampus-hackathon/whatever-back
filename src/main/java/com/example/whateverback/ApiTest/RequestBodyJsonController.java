package com.example.whateverback.ApiTest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RequestBodyJsonController {

    private final ApiService apiService;
    private final String OpenUrl = "https://oapi.saramin.co.kr/job-search?access-key=ijkSv7TGoJUUscgWEezwpUZ31ls9FKFUkjH1ji18LzKBdeWTJcE&keyword=IT";

    @GetMapping("/getApi")
    public ResponseEntity<Map> getApi(){

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
//        headers.set("Content-Type", "application/json");

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> resultMap
                = restTemplate.exchange(OpenUrl, HttpMethod.GET, entity, Map.class);

        System.out.println("리턴..");
        return resultMap;
    }

    @GetMapping("/please")
    public void please(){
        LastTest lastTest = new LastTest();
        lastTest.getPost();
    }

}
