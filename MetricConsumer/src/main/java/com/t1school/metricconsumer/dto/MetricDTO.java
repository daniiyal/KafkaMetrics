package com.t1school.metricconsumer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Доступные для вызова метрики")
public class MetricDTO {
    /**
     * Id метрики
     */
    @Schema(description = "Id метрики")
    private Integer id;

    /**
     * Имя метрики
     */
    @Schema(description = "Имя метрики")
    private String name;
}
