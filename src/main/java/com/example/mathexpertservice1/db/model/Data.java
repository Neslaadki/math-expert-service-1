package com.example.mathexpertservice1.db.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "data")
@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String payload;

    private String expectation;

    private String dispersion;

    private String standardDeviation;

    private String coefficientOfVariation;

    private String confidenceLevel;

    private String autocorrelationShift;

    private String confidenceInterval;

    private String autocorrelationCoefficient;

    private String equalDatasetCount;

    private String equalDatasetArr;


}
