package com.t1school.metricproducer.controller;

import com.t1school.metricproducer.model.MetricRequest;
import com.t1school.metricproducer.model.ResultMessage;
import com.t1school.metricproducer.service.IProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Producer Controller", description = "Producer API сервис для добавления метрик в топик брокера сообщений")
@RestController
@RequestMapping("/api/v1")
public class ProducerController {
    private final IProducerService metricService;

    public ProducerController(IProducerService metricService) {
        this.metricService = metricService;
    }

    @Operation(summary = "Получение метрик приложения",
            description = "Запрашивает метрики из актуатора и передает в топик брокера")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
            @ApiResponse(responseCode = "400", description = "Аргумент вызова не прошел проверку"),
            @ApiResponse(responseCode = "500", description = "Произошла непредвиденная ошибка")}
    )
    @PostMapping("/metrics")
    public ResponseEntity<ResultMessage> getMetrics(@RequestBody MetricRequest metricRequest) {
        return ResponseEntity.ok(new ResultMessage(metricService.getMetrics(metricRequest)));
    }
}
