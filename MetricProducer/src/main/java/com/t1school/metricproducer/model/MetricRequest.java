package com.t1school.metricproducer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Объект запроса, получаемого от консьюмера")
public class MetricRequest {
    /**
     * Id метрики
     */
    @Schema(description = "Id метрики")
    private Integer id;

    /**
     * Имя метрики
     */
    @Schema(description = "Имя метрики")
    private Integer name;
}
