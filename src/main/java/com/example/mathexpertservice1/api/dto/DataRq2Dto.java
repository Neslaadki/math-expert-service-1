package com.example.mathexpertservice1.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataRq2Dto extends DataRqDto {
    @NotNull
    @JsonProperty("confidence_level")
    private Float confidenceLevel;
    @NotNull
    @JsonProperty("autocorrelation_shift")
    private Float autocorrelationShift;
}
