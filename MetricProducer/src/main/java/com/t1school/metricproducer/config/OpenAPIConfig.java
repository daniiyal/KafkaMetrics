package com.t1school.metricproducer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Kafka Producer Api",
                description = "Metric Producer Service", version = "1.0.0",
                contact = @Contact(
                        name = "Daniyal Magomedov"
                )
        )
)
public class OpenAPIConfig {
}
