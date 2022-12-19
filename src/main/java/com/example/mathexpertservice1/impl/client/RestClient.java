package com.example.mathexpertservice1.impl.client;

import com.example.mathexpertservice1.impl.dto.Request2Dto;
import com.example.mathexpertservice1.impl.dto.RequestDto;
import com.example.mathexpertservice1.impl.dto.ResponseDto;

public interface RestClient {
    ResponseDto doPost(String address, RequestDto requestDto);

    ResponseDto doPost(String address, Request2Dto requestDto);
}
