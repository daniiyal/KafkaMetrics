package com.t1school.metricconsumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Объект для запроса метрики у продюсера")
public class MetricRequest {
    /**
     * Id метрики
     */
    @Schema(description = "Id метрики")
    private Integer id;
}
