package com.example.mathexpertservice1.api.controller;

import com.example.mathexpertservice1.api.dto.DataRq2Dto;
import com.example.mathexpertservice1.api.dto.DataRq3Dto;
import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/data")
public interface DataControllerV1 {

    @PostMapping("/v1/analyze")
    DataRsDto analyze(@RequestBody DataRqDto dataRqDto);

    @PostMapping("/v2/analyze")
    DataRsDto analyze(@RequestBody DataRq2Dto dataRqDto);

    @PostMapping("/v3/analyze")
    DataRsDto analyze(@RequestBody DataRq3Dto dataRqDto);

    @GetMapping("/user/{id}")
    List<DataRsDto> getByUserId(@PathVariable("id") UUID id);

}
