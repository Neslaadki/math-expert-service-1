package com.example.mathexpertservice1.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DataRsDto {
    private UUID id;
    private String path;
    private String expectation;
    private String dispersion;
    private String standard_deviation;
    private String coefficient_of_variation;
}
