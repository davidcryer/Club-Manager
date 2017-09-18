package com.davidcryer.web.cloudbasedclubmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClubServicesApplication {

    public static void main(String[] args) {
		SpringApplication.run(ClubServicesApplication.class, args);
	}
}
