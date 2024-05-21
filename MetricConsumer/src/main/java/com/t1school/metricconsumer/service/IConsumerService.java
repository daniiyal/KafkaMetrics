package com.t1school.metricconsumer.service;

import com.t1school.metricconsumer.model.MetricInfo;
import com.t1school.metricconsumer.model.ResultMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IConsumerService {
    /**
     * Метод для сохранения метрики в базу
     *
     * @param metricInfo Информация о метрике
     * @see MetricInfo
     */
    void saveMetrics(MetricInfo metricInfo);

    /**
     * Метод для запроса метрики у продюсера по id
     *
     * @param id Идентификатор метрики
     * @return Результат выполнения запроса
     */
    ResponseEntity<ResultMessage> requestMetrics(Integer id);

    /**
     * Метод для запроса метрик у продюсера
     *
     * @return Результат выполнения запроса
     */
    ResponseEntity<ResultMessage> requestMetrics();

    /**
     * Метод для запроса метрик из базы
     *
     * @return Коллекция с информацией о метриках
     * @see MetricInfo
     */
    List<MetricInfo> getMetrics();

    /**
     * Метод для запроса метрики из базы по id
     *
     * @return Информация о метрике
     * @see MetricInfo
     */
    MetricInfo getMetricsById(long id);
}
