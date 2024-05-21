package com.t1school.metricconsumer.mapper;

import com.t1school.metricconsumer.entity.MeasurementEntity;
import com.t1school.metricconsumer.model.Measurement;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true))
public interface MeasurementMapper {
    @Mapping(target = "id", ignore = true)
    MeasurementEntity modelToEntity(Measurement metricInfo);

    List<MeasurementEntity> modelToEntity(List<Measurement> metricInfo);

    Measurement entityToModel(MeasurementEntity entity);

    List<Measurement> entityToModel(List<MeasurementEntity> metricInfo);
}
