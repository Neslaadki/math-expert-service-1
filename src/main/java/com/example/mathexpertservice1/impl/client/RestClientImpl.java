package com.example.mathexpertservice1.impl.client;

import com.example.mathexpertservice1.impl.dto.Request2Dto;
import com.example.mathexpertservice1.impl.dto.RequestDto;
import com.example.mathexpertservice1.impl.dto.ResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientImpl implements RestClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseDto doPost(String address, RequestDto requestDto) {
        return restTemplate.postForObject(address, requestDto, ResponseDto.class);
    }

    @Override
    public ResponseDto doPost(String address, Request2Dto requestDto) {
        return restTemplate.postForObject(address, requestDto, ResponseDto.class);
    }
}
