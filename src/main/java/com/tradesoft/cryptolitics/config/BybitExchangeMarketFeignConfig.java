package com.tradesoft.cryptolitics.config;

//import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.BybitErrorDecoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BybitExchangeMarketFeignConfig {

    @Value("${resource.bybit.api.url}")
    private String url;

//    @Bean
//    public ErrorDecoder errorDecoder() {
//
//        return new BybitErrorDecoder();
//    }

//    @Bean
//    public BybitExchangeMarketApiV5 bybitExchangeMarketApiV5() {
//
//        return Feign.builder()
////                .decoder(JacksonDecoder())
//                .errorDecoder(new BybitErrorDecoder())
//                .target(BybitExchangeMarketApiV5.class, url);
//
//    }
}
