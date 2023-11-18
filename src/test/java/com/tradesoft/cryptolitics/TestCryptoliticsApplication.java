package com.tradesoft.cryptolitics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCryptoliticsApplication {

	public static void main(String[] args) {
		SpringApplication
				.from(CryptoliticsApplication::main)
				.with(TestCryptoliticsApplication.class)
				.run(args);
	}

}
