package com.example.mathexpertservice1.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataRq3Dto extends DataRq2Dto {
    @NotNull
    @JsonProperty("equal_dataset_count")
    private Integer equalDatasetCount;
}
