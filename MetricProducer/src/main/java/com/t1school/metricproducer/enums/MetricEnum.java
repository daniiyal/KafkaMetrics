package com.t1school.metricproducer.enums;

import lombok.Getter;

@Getter
public enum MetricEnum {
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

    public static MetricEnum findMetricById(int metricId) {
        for (MetricEnum metric : MetricEnum.values()) {
            if (metric.getMetricId() == metricId) {
                return metric;
            }
        }
        return null;
    }
}