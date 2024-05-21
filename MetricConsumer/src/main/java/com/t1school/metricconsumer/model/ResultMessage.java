package com.t1school.metricconsumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Результат выполнения вызова")
public class ResultMessage {
    /**
     * Сообщение
     */
    @Schema(description = "Сообщение")
    private String message;
}
