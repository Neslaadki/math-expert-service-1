package com.example.mathexpertservice1.impl.service;

import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;

import java.util.List;
import java.util.UUID;

public interface DataService {
    DataRsDto analyze(DataRqDto dataRqDto);

    List<DataRsDto> getByUserId(UUID id);
}
