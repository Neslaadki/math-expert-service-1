package com.example.mathexpertservice1.impl.client;

import com.example.mathexpertservice1.impl.dto.RequestDto;
import com.example.mathexpertservice1.impl.dto.ResponseDto;

import java.util.List;

public interface RestClient {
    ResponseDto doPost(String address, RequestDto requestDto);
}