package com.example.mathexpertservice1.impl.service.impl;

import com.example.mathexpertservice1.api.dto.DataRq2Dto;
import com.example.mathexpertservice1.api.dto.DataRq3Dto;
import com.example.mathexpertservice1.api.dto.DataRqDto;
import com.example.mathexpertservice1.api.dto.DataRsDto;
import com.example.mathexpertservice1.db.model.Data;
import com.example.mathexpertservice1.db.repository.DataRepository;
import com.example.mathexpertservice1.db.repository.UserRepository;
import com.example.mathexpertservice1.impl.client.RestClient;
import com.example.mathexpertservice1.impl.dto.Request2Dto;
import com.example.mathexpertservice1.impl.dto.Request3Dto;
import com.example.mathexpertservice1.impl.dto.RequestDto;
import com.example.mathexpertservice1.impl.exception.NoSuchUserFound;
import com.example.mathexpertservice1.impl.service.DataService;
import com.example.mathexpertservice1.impl.util.CSVParser;
import com.example.mathexpertservice1.impl.util.FileReader;
import com.example.mathexpertservice1.impl.util.JsonMapper;
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
    private String service1Url;
    @Value("${math.service-2.url.stat.postV2}")
    private String service2Url;
    @Value("${math.service-2.url.stat.postV3}")
    private String service3Url;


    @Override
    public DataRsDto analyze(DataRqDto dataRqDto) {
        var json = FileReader.read(dataRqDto.getFilePath());
        var user = userRepository.findById(dataRqDto.getUserId());
        if (user.isEmpty()) throw new NoSuchUserFound();
        var data = dataRepository.save(Data.builder().user(user.get()).payload(json).build());
        var dataList = CSVParser.getDataList(data.getPayload());
        var responseDto = restClient.doPost(service1Url, RequestDto.builder().dataset(dataList).build());
        data = data.toBuilder()
                .dispersion(responseDto.getDispersion())
                .expectation(responseDto.getExpectation())
                .coefficientOfVariation(responseDto.getCoefficient_of_variation())
                .standardDeviation(responseDto.getStandard_deviation())
                .build();
        dataRepository.save(data);
        return DataRsDto.builder()
                .id(data.getId())
                .dispersion(data.getDispersion())
                .expectation(data.getExpectation())
                .standardDeviation(data.getStandardDeviation())
                .coefficientOfVariation(data.getCoefficientOfVariation())
                .build();
    }

    @Override
    public DataRsDto analyze(DataRq2Dto dataRqDto) {
        var json = FileReader.read(dataRqDto.getFilePath());
        var user = userRepository.findById(dataRqDto.getUserId());
        if (user.isEmpty()) throw new NoSuchUserFound();
        var data = dataRepository.save(
                Data.builder()
                        .user(user.get())
                        .payload(json)
                        .confidenceLevel(dataRqDto.getConfidenceLevel().toString())
                        .autocorrelationShift(dataRqDto.getAutocorrelationShift().toString())
                        .build());
        var dataList = CSVParser.getDataList(data.getPayload());
        var responseDto = restClient.doPost(service2Url,
                Request2Dto.builder()
                        .autocorrelationShift(dataRqDto.getAutocorrelationShift())
                        .confidenceLevel(dataRqDto.getConfidenceLevel())
                        .dataset(dataList)
                        .build());
        data = data.toBuilder()
                .dispersion(responseDto.getDispersion())
                .expectation(responseDto.getExpectation())
                .coefficientOfVariation(responseDto.getCoefficient_of_variation())
                .standardDeviation(responseDto.getStandard_deviation())
                .confidenceInterval(responseDto.getConfidence_interval())
                .autocorrelationCoefficient(responseDto.getAutocorrelation_coefficient())
                .build();
        dataRepository.save(data);
        return DataRsDto.builder()
                .id(data.getId())
                .dispersion(data.getDispersion())
                .expectation(data.getExpectation())
                .standardDeviation(data.getStandardDeviation())
                .coefficientOfVariation(data.getCoefficientOfVariation())
                .autocorrelationShift(data.getAutocorrelationShift())
                .autocorrelationCoefficient(data.getAutocorrelationCoefficient())
                .confidenceLevel(data.getConfidenceLevel())
                .confidenceInterval(data.getConfidenceInterval())
                .build();
    }

    @Override
    public DataRsDto analyze(DataRq3Dto dataRqDto) {
        var json = FileReader.read(dataRqDto.getFilePath());
        var user = userRepository.findById(dataRqDto.getUserId());
        if (user.isEmpty()) throw new NoSuchUserFound();
        var data = dataRepository.save(
                Data.builder()
                        .user(user.get())
                        .payload(json)
                        .confidenceLevel(dataRqDto.getConfidenceLevel().toString())
                        .autocorrelationShift(dataRqDto.getAutocorrelationShift().toString())
                        .equalDatasetCount(dataRqDto.getEqualDatasetCount().toString())
                        .build());
        var dataList = CSVParser.getDataList(data.getPayload());
        var responseDto = restClient.doPost(service3Url,
                Request3Dto.builder()
                        .autocorrelationShift(dataRqDto.getAutocorrelationShift())
                        .confidenceLevel(dataRqDto.getConfidenceLevel())
                        .equalDatasetCount(dataRqDto.getEqualDatasetCount())
                        .dataset(dataList)
                        .build());
        data = data.toBuilder()
                .dispersion(responseDto.getDispersion())
                .expectation(responseDto.getExpectation())
                .coefficientOfVariation(responseDto.getCoefficient_of_variation())
                .standardDeviation(responseDto.getStandard_deviation())
                .confidenceInterval(responseDto.getConfidence_interval())
                .autocorrelationCoefficient(responseDto.getAutocorrelation_coefficient())
                .equalDatasetCount(dataRqDto.getEqualDatasetCount().toString())
                .equalDatasetArr(JsonMapper.toJson(responseDto.getEqual_dataset()))
                .build();
        dataRepository.save(data);
        return DataRsDto.builder()
                .id(data.getId())
                .dispersion(data.getDispersion())
                .expectation(data.getExpectation())
                .standardDeviation(data.getStandardDeviation())
                .coefficientOfVariation(data.getCoefficientOfVariation())
                .autocorrelationShift(data.getAutocorrelationShift())
                .autocorrelationCoefficient(data.getAutocorrelationCoefficient())
                .confidenceLevel(data.getConfidenceLevel())
                .confidenceInterval(data.getConfidenceInterval())
                .equalDataset(data.getEqualDatasetArr())
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
                .standardDeviation(data.getStandardDeviation())
                .coefficientOfVariation(data.getCoefficientOfVariation())
                .build()).toList();
    }
}
