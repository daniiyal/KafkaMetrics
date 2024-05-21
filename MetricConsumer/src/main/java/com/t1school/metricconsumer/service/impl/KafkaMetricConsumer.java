package com.t1school.metricconsumer.service.impl;

import com.t1school.metricconsumer.model.MetricInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMetricConsumer {
    private final ConsumerService consumerService;

    public KafkaMetricConsumer(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    /**
     * Метод для ожидания сообщений от продюсера
     *
     * @param metricInfo Информация о метрике
     */
    @KafkaListener(topics = {"${spring.kafka.topic}"})
    public void listenMetrics(@Payload MetricInfo metricInfo) {
        try{
            log.info("Получено сообщение: {}", metricInfo);
            consumerService.saveMetrics(metricInfo);
            log.info("Метрика сохранена");
        } catch (Exception e){
            log.error("Ошибка при обработке входящего сообщения", e);
        }

    }
}
