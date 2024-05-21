package com.t1school.metricproducer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Показания метрики")
public class Measurement {
    /**
     * Характеристика значения метрики
     */
    @Schema(description = "Характеристика значения метрики")
    private String statistic;

    /**
     * Значение метрики
     */
    @Schema(description = "Значение метрики")
    private String value;
}
