package com.t1school.metricproducer.service.impl;

import com.t1school.metricproducer.enums.MetricEnum;
import com.t1school.metricproducer.model.MetricInfo;
import com.t1school.metricproducer.service.IMetricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class MetricService implements IMetricService {

    private final RestClient restClient;

    public MetricService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<MetricInfo> getAllMetrics() {
        try {
            List<String> allMetricNames = Arrays.stream(MetricEnum.values())
                    .map(MetricEnum::getMetricName)
                    .toList();

            return allMetricNames.stream().map(this::getMetricInfo).toList();
        } catch (Exception e) {
            log.error("При сборе информации о всех метриках произошла ошибка {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public MetricInfo getMetricById(Integer metricId) {
        MetricEnum metricEnum = MetricEnum.findMetricById(metricId);

        if (metricEnum == null) {
            log.error("Не удалось найти метрику с таким metricId {}", metricId);
            throw new IllegalArgumentException(String.format("Не удалось найти метрику с таким metricId %s", metricId));
        }

        return getMetricInfo(metricEnum.getMetricName());
    }

    private MetricInfo getMetricInfo(String metricName) {
        try {
            log.info("Запрос информации о метрике {}", metricName);

            String actuatorUrl = "http://localhost:8080/actuator/metrics/";

            MetricInfo metricInfo = restClient.get()
                    .uri(actuatorUrl + metricName)
                    .retrieve()
                    .body(MetricInfo.class);

            log.info("Получена информация о метрике {}", metricInfo);

            return metricInfo;
        } catch (Exception e) {
            log.error("При получении информации о метрике {} произошла ошибка {}", metricName, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
