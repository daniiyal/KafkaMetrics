package com.t1school.metricconsumer.service.impl;

import com.t1school.metricconsumer.entity.MeasurementEntity;
import com.t1school.metricconsumer.entity.MetricEntity;
import com.t1school.metricconsumer.mapper.MeasurementMapper;
import com.t1school.metricconsumer.mapper.MetricMapper;
import com.t1school.metricconsumer.model.MetricInfo;
import com.t1school.metricconsumer.repository.MetricEntityRepository;
import com.t1school.metricconsumer.service.IMetricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MetricService implements IMetricService {
    private final MetricEntityRepository metricEntityRepository;
    private final MetricMapper metricMapper;
    private final MeasurementMapper measurementMapper;

    public MetricService(MetricEntityRepository metricEntityRepository, MetricMapper metricMapper, MeasurementMapper measurementMapper) {
        this.metricEntityRepository = metricEntityRepository;
        this.metricMapper = metricMapper;
        this.measurementMapper = measurementMapper;
    }

    @Override
    public void saveMetrics(MetricInfo metricInfo) {
        try {
            Optional<MetricEntity> optionalMetricEntity = metricEntityRepository.findByName(metricInfo.getName());

            if (optionalMetricEntity.isEmpty()) {
                MetricEntity metricEntity = metricMapper.modelToEntity(metricInfo);
                metricEntityRepository.save(metricEntity);
                return;
            }

            MetricEntity metricEntity = optionalMetricEntity.get();

            List<MeasurementEntity> measurementEntityList = metricEntity.getMeasurements();
            measurementEntityList.addAll(metricInfo.getMeasurements().stream().map(measurementMapper::modelToEntity).toList());

            metricEntity.setMeasurements(measurementEntityList);

            metricEntityRepository.save(metricEntity);
        } catch (Exception e) {
            log.error("Не удалось сохранить метрику {}. Ошибка: {}", metricInfo, e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<MetricInfo> getMetrics() {
        try {
            List<MetricEntity> metricEntities = metricEntityRepository.findAll();
            return metricMapper.entityToModelList(metricEntities);
        } catch (Exception e) {
            log.error("Не удалось получить метрики. Ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public MetricInfo getMetricsById(long id) {
        try {
            Optional<MetricEntity> metricEntity = metricEntityRepository.findById(id);
            return metricEntity.map(metricMapper::entityToModel)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("Не удалось получить метрики c id: %d", id)));
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            log.error("Не удалось получить метрики c id: {}. Ошибка: {}", id, e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
