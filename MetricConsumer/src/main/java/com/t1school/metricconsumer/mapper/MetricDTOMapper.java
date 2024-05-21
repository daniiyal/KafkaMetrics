package com.t1school.metricconsumer.mapper;


import com.t1school.metricconsumer.dto.MetricDTO;
import com.t1school.metricconsumer.enums.MetricEnum;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true))
public interface MetricDTOMapper {
    @Mapping(target = "id", source = "metricId")
    @Mapping(target = "name", source = "metricName")
    MetricDTO MetricEnumToDTO(MetricEnum metricEnum);

    List<MetricDTO> metricDTOListToDTOList(List<MetricEnum> metricEnumList);
}
