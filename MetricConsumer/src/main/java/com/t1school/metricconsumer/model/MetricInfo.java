package com.t1school.metricconsumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Информация о метрике")
public class MetricInfo {
    /**
     * Наименование метрики
     */
    @Schema(description = "Наименование метрики")
    private String name;

    /**
     * Описание метрики
     */
    @Schema(description = "Описание метрики")
    private String description;

    /**
     * Единица измерения
     */
    @Schema(description = "Единица измерения")
    private String baseUnit;

    /**
     * Список показаний метрики
     */
    @Schema(description = "Список показаний метрики")
    private List<Measurement> measurements;
}
