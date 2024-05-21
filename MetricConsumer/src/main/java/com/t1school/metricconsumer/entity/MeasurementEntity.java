package com.t1school.metricconsumer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long id;

    private String statistic;

    private String value;
}
