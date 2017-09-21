package com.davidcryer.common.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MemberServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberServicesApplication.class, args);
    }
}
