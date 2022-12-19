package com.example.mathexpertservice1.impl.util;

import com.example.mathexpertservice1.impl.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

public class CSVParser {

    public static List<Float> getDataList(String data) {
        try {
            return Arrays.stream(data.trim().split(",")).map(Float::parseFloat).toList();
        } catch (Exception e) {
            throw new InvalidDataException();
        }
    }
}
