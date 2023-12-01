package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKlineBybitApiResponse;
import com.tradesoft.cryptolitics.domain.market.KLine;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KlineMapper {

    public static KLineGraph toDomain(@NotNull GetKlineBybitApiResponse.Kline dto) {
        if (dto != null && dto.list() != null) {

            return new KLineGraph(
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

    public static KLine mapCandleStick(@NotNull List<String> candleStick) {
        if (candleStick.isEmpty()) {
            throw new IllegalStateException();
        } else {

            return new KLine(
                    LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(Long.parseLong(candleStick.get(0))),
                            ZoneId.of("UTC")
                    ),
                    BigDecimal.valueOf(Double.parseDouble(candleStick.get(1))),
                    BigDecimal.valueOf(Double.parseDouble(candleStick.get(2))),
                    BigDecimal.valueOf(Double.parseDouble(candleStick.get(3))),
                    BigDecimal.valueOf(Double.parseDouble(candleStick.get(4))),
                    BigDecimal.valueOf(Double.parseDouble(candleStick.get(5))),
                    BigDecimal.valueOf(Double.parseDouble(candleStick.get(6)))
            );
        }
    }
}
