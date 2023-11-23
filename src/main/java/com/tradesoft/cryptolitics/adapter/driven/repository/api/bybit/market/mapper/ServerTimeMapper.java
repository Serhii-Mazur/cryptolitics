package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.domain.ServerTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ServerTimeMapper {

    public static ServerTime toDomain(GetServerTimeBybitApiResponse apiResponse) {

        return new ServerTime(
                LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(apiResponse.time()),
                        ZoneId.systemDefault()
                )
        );
    }
}
