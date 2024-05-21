package com.t1school.metricconsumer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MetricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metric_id")
    private Long id;

    private String name;

    private String description;

    private String baseUnit;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MeasurementEntity> measurements;
}
