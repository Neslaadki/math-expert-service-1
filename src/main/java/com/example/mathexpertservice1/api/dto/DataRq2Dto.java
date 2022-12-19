package com.example.mathexpertservice1.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
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
