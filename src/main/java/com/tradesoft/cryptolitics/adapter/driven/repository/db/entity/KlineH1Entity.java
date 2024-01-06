package com.tradesoft.cryptolitics.adapter.driven.repository.db.entity;

import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "klines_h1")
public record KlineH1Entity(
        @Id
        KlineId id,
        BigDecimal openPrice,
        BigDecimal highPrice,
        BigDecimal lowPrice,
        BigDecimal closePrice,
        BigDecimal volume,
        BigDecimal turnover
) {
    public record KlineId(
            CoinPair coinPair,
            LocalDateTime startDateTime
    ) {
    }
}


