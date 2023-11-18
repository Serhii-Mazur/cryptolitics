package com.tradesoft.cryptolitics.adapter.driven.repository.db.bybit.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.domain.ServerTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ServerTimeMapper {

    public static ServerTime toDomain(GetServerTimeBybitApiResponse apiResponse) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(apiResponse.time()), ZoneId.systemDefault()
        );

        return new ServerTime(dateTime);
    }
}
