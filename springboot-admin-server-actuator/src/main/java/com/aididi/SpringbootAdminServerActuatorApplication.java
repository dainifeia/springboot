package com.aididi;

import de.codecentric.boot.admin.config.EnableAdminServer;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@EnableAdminServer
public class SpringbootAdminServerActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAdminServerActuatorApplication.class, args);
	}
}
