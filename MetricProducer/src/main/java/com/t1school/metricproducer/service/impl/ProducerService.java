package com.t1school.metricproducer.service.impl;

import com.t1school.metricproducer.model.MetricInfo;
import com.t1school.metricproducer.model.MetricRequest;
import com.t1school.metricproducer.service.IMetricService;
import com.t1school.metricproducer.service.IProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProducerService implements IProducerService {

    @Value("${spring.kafka.topic}")
    private String metricTopic;

    private final IMetricService metricService;

    private final KafkaTemplate<String, MetricInfo> kafkaTemplate;

    public ProducerService(IMetricService metricService, KafkaTemplate<String, MetricInfo> kafkaTemplate) {
        this.metricService = metricService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String getMetrics(MetricRequest metricRequest) {
        Integer metricId = metricRequest.getId();

        if (metricId == 0) {
            List<MetricInfo> metricInfoList = metricService.getAllMetrics();
            metricInfoList.forEach(metricInfo -> kafkaTemplate.send(metricTopic, metricInfo));
            return "Отправлена информация о всех метриках";
        }

        kafkaTemplate.send(metricTopic, metricService.getMetricById(metricId));
        return String.format("Отправлена информация о метрике с id %s", metricId);
    }

}
