package com.example.mathexpertservice1.impl.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


public class JsonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String toJson(Object o){
        return objectMapper.writeValueAsString(o);
    }
}
