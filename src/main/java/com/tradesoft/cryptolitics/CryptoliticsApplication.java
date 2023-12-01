package com.tradesoft.cryptolitics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.tradesoft.cryptolitics.*"})
@EnableFeignClients
//@EnableMongoRepositories(
//        basePackages = "com.tradesoft.cryptolitics.adapter.driven.repository.db.*"
//        excludeFilters = { @Filter(type = FilterType.REGEX, pattern = ".MongoRepositoriesAutoConfiguration") }
//)
public class CryptoliticsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CryptoliticsApplication.class, args);
    }
}
