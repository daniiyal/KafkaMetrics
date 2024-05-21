package com.t1school.metricconsumer.enums;

import lombok.Getter;

@Getter
public enum MetricEnum {
    ALL(0, "Все метрики"),
    APP_STARTED(1, "application.started.time"),
    DISK_FREE(2, "disk.free"),
    DISK_TOTAL(3, "disk.total"),
    JVM_MEMORY_MAX(4, "jvm.memory.max"),
    JVM_MEMORY_USED(5, "jvm.memory.used"),
    HTTP_SERVER_REQUESTS(6, "http.server.requests"),
    PROCESS_UPTIME(7, "process.uptime");

    final int metricId;

    final String metricName;

    MetricEnum(int metricId, String metricName) {
        this.metricId = metricId;
        this.metricName = metricName;
    }
}