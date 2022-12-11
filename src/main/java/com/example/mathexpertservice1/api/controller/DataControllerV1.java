package com.example.mathexpertservice1.api.controller;

import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("v1/data")
public interface DataControllerV1 {

    @PostMapping("/analyze")
    DataRsDto analyze(@RequestBody DataRqDto dataRqDto);

    @GetMapping("/user/{id}")
    List<DataRsDto> getByUserId(@PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") UUID id);


}
