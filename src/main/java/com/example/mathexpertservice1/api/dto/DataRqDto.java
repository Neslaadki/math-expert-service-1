package com.example.mathexpertservice1.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataRqDto {
    @NotNull
    private UUID userId;
    @NotBlank
    private String filePath;
}
