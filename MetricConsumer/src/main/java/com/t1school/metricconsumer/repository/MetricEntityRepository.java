package com.t1school.metricconsumer.repository;

import com.t1school.metricconsumer.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetricEntityRepository extends JpaRepository<MetricEntity, Long> {
    /**
     * Получение сущности метрики по имени
     *
     * @param name Имя метрики
     * @return Optional сущность метрики
     */
    Optional<MetricEntity> findByName(String name);
}
