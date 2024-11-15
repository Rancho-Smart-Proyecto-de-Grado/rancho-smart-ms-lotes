package com.rancho_smart.ms_lotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsLotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLotesApplication.class, args);
	}

}
