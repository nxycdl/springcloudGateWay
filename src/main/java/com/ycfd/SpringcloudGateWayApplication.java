package com.ycfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudGateWayApplication.class, args);
	}

}

