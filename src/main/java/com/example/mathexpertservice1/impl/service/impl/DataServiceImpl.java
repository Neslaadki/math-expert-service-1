package com.example.mathexpertservice1.impl.service.impl;

import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;
import com.example.mathexpertservice1.db.model.Data;
import com.example.mathexpertservice1.db.repository.DataRepository;
import com.example.mathexpertservice1.db.repository.UserRepository;
import com.example.mathexpertservice1.impl.client.RestClient;
import com.example.mathexpertservice1.impl.dto.RequestDto;
import com.example.mathexpertservice1.impl.exception.NoSuchUserFound;
import com.example.mathexpertservice1.impl.service.DataService;
import com.example.mathexpertservice1.impl.util.CSVParser;
import com.example.mathexpertservice1.impl.util.FileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;
    private final UserRepository userRepository;
    private final RestClient restClient;
    @Value("${math.service-2.url.stat.post}")
    private String service2Url;

    @Override
    public DataRsDto analyze(DataRqDto dataRqDto) {
        var json = FileReader.read(dataRqDto.getFilePath());
        var user = userRepository.findById(dataRqDto.getUserId());
        if (user.isEmpty()) throw new NoSuchUserFound();
        var data = dataRepository.save(Data.builder().user(user.get()).payload(json).build());
        var dataList = CSVParser.getDataList(data.getPayload());
        var responseDto = restClient.doPost(service2Url, RequestDto.builder().array(dataList).build());
        data = data.toBuilder()
                .dispersion(responseDto.getDispersion())
                .expectation(responseDto.getExpectation())
                .coefficientOfVariation(responseDto.getCoefficient_of_variation())
                .standardDeviation(responseDto.getStandard_deviation()).build();
        dataRepository.save(data);
        return DataRsDto.builder()
                .id(data.getId())
                .dispersion(data.getDispersion())
                .expectation(data.getExpectation())
                .standard_deviation(data.getStandardDeviation())
                .coefficient_of_variation(data.getCoefficientOfVariation())
                .build();
    }

    @Override
    public List<DataRsDto> getByUserId(UUID id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new NoSuchUserFound();
        return dataRepository.findByUser(user.get()).stream().map(data -> DataRsDto.builder()
                .id(data.getId())
                .dispersion(data.getDispersion())
                .expectation(data.getExpectation())
                .standard_deviation(data.getStandardDeviation())
                .coefficient_of_variation(data.getCoefficientOfVariation())
                .build()).toList();
    }
}
