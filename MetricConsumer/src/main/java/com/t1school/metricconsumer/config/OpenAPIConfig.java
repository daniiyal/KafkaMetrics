package com.t1school.metricconsumer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Kafka Consumer Api",
                description = "Metric Consumer Service", version = "1.0.0",
                contact = @Contact(
                        name = "Daniyal Magomedov"
                )
        )
)
public class OpenAPIConfig {
}
