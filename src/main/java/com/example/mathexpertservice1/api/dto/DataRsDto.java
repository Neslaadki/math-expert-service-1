package com.example.mathexpertservice1.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataRsDto {
    private UUID id;
    private String expectation;
    private String dispersion;
    @JsonProperty("standard_deviation")
    private String standardDeviation;
    @JsonProperty("coefficient_of_variation")
    private String coefficientOfVariation;
    @JsonProperty("confidence_level")
    private String confidenceLevel;
    @JsonProperty("autocorrelation_shift")
    private String autocorrelationShift;
    @JsonProperty("confidence_interval")
    private String confidenceInterval;
    @JsonProperty("autocorrelation_coefficient")
    private String autocorrelationCoefficient;
}
