package com.example.mathexpertservice1.impl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Request2Dto extends RequestDto{
    @NotNull
    @JsonProperty("confidence_level")
    private Float confidenceLevel;
    @NotNull
    @JsonProperty("autocorrelation_shift")
    private Float autocorrelationShift;
}
