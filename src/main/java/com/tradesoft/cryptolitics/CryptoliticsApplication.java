package com.tradesoft.cryptolitics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class CryptoliticsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CryptoliticsApplication.class, args);
    }
}
