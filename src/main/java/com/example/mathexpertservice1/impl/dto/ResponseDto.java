package com.example.mathexpertservice1.impl.dto;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String expectation;
    private String dispersion;
    private String standard_deviation;
    private String coefficient_of_variation;
}
