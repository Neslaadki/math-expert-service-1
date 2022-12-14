package com.example.mathexpertservice1.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("user_id")
    private UUID userId;
    @NotBlank
    @JsonProperty("file_path")
    private String filePath;
}
