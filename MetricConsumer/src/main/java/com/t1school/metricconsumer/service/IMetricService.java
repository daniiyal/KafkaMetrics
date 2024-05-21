package com.t1school.metricconsumer.service;

import com.t1school.metricconsumer.model.MetricInfo;

import java.util.List;

public interface IMetricService {
    /**
     * Метод для сохранения метрики в базу
     *
     * @param metricInfo Информация о метрике
     * @see MetricInfo
     */
    void saveMetrics(MetricInfo metricInfo);

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
