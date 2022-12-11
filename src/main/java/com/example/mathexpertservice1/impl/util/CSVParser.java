package com.example.mathexpertservice1.impl.util;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class CSVParser {

    public static List<Float> getDataList(String data) {
        try{
            return Arrays.stream(data.trim().split(",")).map(Float::parseFloat).toList();
        }catch (Exception e){
            throw new RuntimeException("Values in a file should be write in a CSV-format. Example: 10.1, 10.2, ..");
        }
    }
}
