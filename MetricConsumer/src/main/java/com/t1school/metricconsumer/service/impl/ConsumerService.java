package com.t1school.metricconsumer.service.impl;

import com.t1school.metricconsumer.model.MetricInfo;
import com.t1school.metricconsumer.model.MetricRequest;
import com.t1school.metricconsumer.model.ResultMessage;
import com.t1school.metricconsumer.repository.MetricEntityRepository;
import com.t1school.metricconsumer.service.IConsumerService;
import com.t1school.metricconsumer.service.IMetricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@Slf4j
public class ConsumerService implements IConsumerService {

    @Value("${app.producer.url}")
    private String producerUrl;

    private final IMetricService metricService;
    private final RestClient restClient;

    public ConsumerService(IMetricService metricService, RestClient restClient) {
        this.metricService = metricService;
        this.restClient = restClient;
    }


    @Override
    public void saveMetrics(MetricInfo metricInfo) {
        metricService.saveMetrics(metricInfo);
    }

    @Override
    public ResponseEntity<ResultMessage> requestMetrics(Integer id) {
        String requestUrl = UriComponentsBuilder.fromUriString(producerUrl)
                .path("/metrics")
                .build().toUriString();

        return restClient.post()
                .uri(requestUrl)
                .body(new MetricRequest(id))
                .retrieve()
                .onStatus(status -> status.value() == 400, (request, response) -> {
                    throw new IllegalArgumentException(String.format("Не удалось найти метрику с id %s", id));
                })
                .toEntity(ResultMessage.class);
    }

    @Override
    public ResponseEntity<ResultMessage> requestMetrics() {
        return requestMetrics(0);
    }

    @Override
    public List<MetricInfo> getMetrics() {
        return metricService.getMetrics();
    }

    @Override
    public MetricInfo getMetricsById(long id) {
        return metricService.getMetricsById(id);
    }

}
