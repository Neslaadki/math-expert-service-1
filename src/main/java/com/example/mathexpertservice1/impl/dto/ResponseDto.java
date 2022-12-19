package com.example.mathexpertservice1.impl.dto;

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
    private String confidence_interval;
    private String autocorrelation_coefficient;
}
