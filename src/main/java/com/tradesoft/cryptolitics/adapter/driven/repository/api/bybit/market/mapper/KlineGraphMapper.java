package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKLineBybitApiResponse;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KlineGraphMapper {
    public static KLineGraph toDomain(GetKLineBybitApiResponse.KLine dto) {
        if (dto == null) {
            throw new IllegalStateException("DTO can't be NULL.");
        } else if (dto.list() != null) {

            return new KLineGraph(
                    CoinPair.getValue(dto.symbol()),
                    dto.list().stream()
                            .filter(Objects::nonNull)
                            .map(KlineGraphMapper::mapKLine)
                            .collect(Collectors.toList())
            );
        } else {

            return KLineGraph.empty(CoinPair.valueOf(dto.symbol()));
        }
    }

    public static KLine mapKLine(List<String> values) {
        if (values.isEmpty()) {
            throw new IllegalStateException();
        } else {

            return new KLine(
                    LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(Long.parseLong(values.get(0))),
                            ZoneId.systemDefault()
                    ),
                    BigDecimal.valueOf(Double.parseDouble(values.get(1))),
                    BigDecimal.valueOf(Double.parseDouble(values.get(2))),
                    BigDecimal.valueOf(Double.parseDouble(values.get(3))),
                    BigDecimal.valueOf(Double.parseDouble(values.get(4))),
                    BigDecimal.valueOf(Double.parseDouble(values.get(5))),
                    BigDecimal.valueOf(Double.parseDouble(values.get(6)))
            );
        }
    }
}
