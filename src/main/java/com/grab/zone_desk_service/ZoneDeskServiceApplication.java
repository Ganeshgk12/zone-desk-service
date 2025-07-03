package com.grab.zone_desk_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZoneDeskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoneDeskServiceApplication.class, args);
	}

}
