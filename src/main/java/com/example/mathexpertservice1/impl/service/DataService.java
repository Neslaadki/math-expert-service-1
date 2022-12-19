package com.example.mathexpertservice1.impl.service;

import com.example.mathexpertservice1.api.dto.DataRq2Dto;
import com.example.mathexpertservice1.api.dto.DataRq3Dto;
import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;

import java.util.List;
import java.util.UUID;

public interface DataService {
    DataRsDto analyze(DataRqDto dataRqDto);

    DataRsDto analyze(DataRq2Dto dataRqDto);

    DataRsDto analyze(DataRq3Dto dataRqDto);

    List<DataRsDto> getByUserId(UUID id);
}
