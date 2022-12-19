package com.example.mathexpertservice1.impl.controller;

import com.example.mathexpertservice1.api.controller.DataControllerV1;
import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;
import com.example.mathexpertservice1.impl.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DataControllerV1Impl implements DataControllerV1 {
    private final DataService dataService;

    @Override
    public DataRsDto analyze(DataRqDto dataRqDto) {
        return dataService.analyze(dataRqDto);
    }

    @Override
    public List<DataRsDto> getByUserId(UUID id) {
        return dataService.getByUserId(id);
    }


}
