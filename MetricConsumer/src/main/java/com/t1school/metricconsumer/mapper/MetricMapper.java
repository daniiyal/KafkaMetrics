package com.t1school.metricconsumer.mapper;

import com.t1school.metricconsumer.entity.MetricEntity;
import com.t1school.metricconsumer.model.MetricInfo;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true),
        uses = MeasurementMapper.class)
public interface MetricMapper {
    @Mapping(target = "id", ignore = true)
    MetricEntity modelToEntity(MetricInfo metricInfo);

    List<MetricEntity> modelToEntity(List<MetricInfo> metricInfoList);

    MetricInfo entityToModel(MetricEntity metricEntity);

    List<MetricInfo> entityToModelList(List<MetricEntity> metricEntityList);
}