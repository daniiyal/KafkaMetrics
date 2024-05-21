package com.t1school.metricconsumer.controller;

import com.t1school.metricconsumer.dto.MetricDTO;
import com.t1school.metricconsumer.enums.MetricEnum;
import com.t1school.metricconsumer.mapper.MetricDTOMapper;
import com.t1school.metricconsumer.model.MetricInfo;
import com.t1school.metricconsumer.model.ResultMessage;
import com.t1school.metricconsumer.service.IConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Consumer Controller", description = "Consumer API сервис для запроса метрик у продюсера и получения значений из БД")
@RestController
@RequestMapping("/api/v1")
public class ConsumerController {

    private final MetricDTOMapper metricDTOMapper;
    private final IConsumerService consumerService;

    public ConsumerController(MetricDTOMapper metricDTOMapper, IConsumerService consumerService) {
        this.metricDTOMapper = metricDTOMapper;
        this.consumerService = consumerService;
    }

    @Operation(summary = "Получение списка доступных для запроса метрик",
            description = "Возвращает доступные метрики в виде id-name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
            @ApiResponse(responseCode = "500", description = "Произошла непредвиденная ошибка")}
    )
    @GetMapping("/metrics/list")
    public ResponseEntity<List<MetricDTO>> getMetricList() {
        return ResponseEntity.ok(metricDTOMapper.metricDTOListToDTOList(List.of(MetricEnum.values())));
    }

    @Operation(summary = "Запрос всех метрик у продюсера",
            description = "Запрашивает все метрики у продюсера")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
            @ApiResponse(responseCode = "500", description = "Произошла непредвиденная ошибка")}
    )
    @GetMapping("/metrics")
    public ResponseEntity<ResultMessage> getMetrics() {
        return consumerService.requestMetrics();
    }

    @Operation(summary = "Запрос метрики у продюсера по id",
            description = "Запрашивает метрику у продюсера по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
            @ApiResponse(responseCode = "400", description = "Аргумент вызова не прошел проверку"),
            @ApiResponse(responseCode = "500", description = "Произошла непредвиденная ошибка")}
    )
    @GetMapping("/metrics/{id}")
    public ResponseEntity<ResultMessage> getMetricsById(@PathVariable int id) throws Exception {
        return consumerService.requestMetrics(id);
    }

    @Operation(summary = "Получение показаний метрик из БД",
            description = "Запрашивает метрики и показания метрик из БД")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
            @ApiResponse(responseCode = "500", description = "Произошла непредвиденная ошибка")}
    )
    @GetMapping("/metrics/stats/all")
    public ResponseEntity<List<MetricInfo>> getAllMetrics() {
        return ResponseEntity.ok(consumerService.getMetrics());
    }

    @Operation(summary = "Получение показаний метрики из БД по id",
            description = "Запрашивает показания метрики из БД по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
            @ApiResponse(responseCode = "400", description = "Аргумент вызова не прошел проверку"),
            @ApiResponse(responseCode = "500", description = "Произошла непредвиденная ошибка")}
    )
    @GetMapping("/metrics/stats/{id}")
    public ResponseEntity<MetricInfo> getAllMetrics(@PathVariable long id) {
        return ResponseEntity.ok(consumerService.getMetricsById(id));
    }

}
