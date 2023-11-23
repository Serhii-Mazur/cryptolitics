package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKlineBybitApiResponse;
import com.tradesoft.cryptolitics.domain.market.CandleStick;
import com.tradesoft.cryptolitics.domain.market.Kline;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KlineMapper {

    public static Kline toDomain(GetKlineBybitApiResponse.Kline dto) {
        if (dto != null) {

            return new Kline(
//                    Category.valueOf(dto.category().toUpperCase()),
                    dto.category(),
//                    CoinPair.valueOf(dto.symbol().toUpperCase()),
                    dto.symbol(),
                    dto.list().stream()
                            .filter(Objects::nonNull)
                            .map(KlineMapper::mapCandleStick)
                            .collect(Collectors.toList())
            );
        } else {

            return null;
        }
    }

    public static CandleStick mapCandleStick(List<String> list) {

        return new CandleStick(
                LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(Long.parseLong(list.get(0))),
                        ZoneId.of("UTC")
                ),
                BigDecimal.valueOf(Long.parseLong(list.get(1))),
                BigDecimal.valueOf(Long.parseLong(list.get(2))),
                BigDecimal.valueOf(Long.parseLong(list.get(3))),
                BigDecimal.valueOf(Long.parseLong(list.get(4))),
                BigDecimal.valueOf(Long.parseLong(list.get(5))),
                BigDecimal.valueOf(Long.parseLong(list.get(6)))
        );
    }
}
