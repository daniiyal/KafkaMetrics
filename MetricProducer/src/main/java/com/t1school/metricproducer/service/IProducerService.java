package com.t1school.metricproducer.service;

import com.t1school.metricproducer.model.MetricRequest;

public interface IProducerService {
    /**
     * Отправить текущие метрики в кафку
     *
     * @return Результат отправки
     * @see MetricRequest
     */
    String getMetrics(MetricRequest metricRequest);
}
