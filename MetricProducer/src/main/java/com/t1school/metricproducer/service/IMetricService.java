package com.t1school.metricproducer.service;

import com.t1school.metricproducer.model.MetricInfo;

import java.util.List;

public interface IMetricService {
    /**
     * Получение информации о метриках из актуатора
     *
     * @return Коллекция с информацией о метриках
     * @see MetricInfo
     */
    List<MetricInfo> getAllMetrics();

    /**
     * Получение информации о метрике из актуатора по Id
     *
     * @return Информация о метрике
     * @see MetricInfo
     */
    MetricInfo getMetricById(Integer metricId);
}
