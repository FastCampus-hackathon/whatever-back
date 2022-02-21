package com.example.whateverback.ApiTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ApiService {

    private final String OpenUrl = "https://oapi.saramin.co.kr/job-search?access-key=ijkSv7TGoJUUscgWEezwpUZ31ls9FKFUkjH1ji18LzKBdeWTJcE&keyword=IT";

    public ResponseEntity<Map> requestPost(){
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
//        headers.set("Content-Type", "application/json");

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> resultMap = restTemplate.exchange(OpenUrl, HttpMethod.GET, entity, Map.class);
//        HashMap<String, Object> result = new HashMap<String, Object>();

//        result.put("statusCode", resultMap.getStatusCodeValue());
//        result.put("header", resultMap.getHeaders());
//        result.put("body", resultMap.getBody());
//
//        String jsonInString = "";
//        ObjectMapper mapper = new  ObjectMapper();
//        try{
//            jsonInString = mapper.writeValueAsString(resultMap.getBody());
//        } catch (HttpClientErrorException | HttpServerErrorException e){
//            result.put("statusCode", e.getRawStatusCode());
//            result.put("body"  , e.getStatusText());
//            System.out.println("dfdfdfdf");
//            System.out.println(e.toString());
//        }  catch (Exception e) {
//            result.put("statusCode", "999");
//            result.put("body", "excpetion오류");
//            System.out.println(e.toString());
//        }

        System.out.println("리턴..");
        return resultMap;

    }

}
