package com.tradesoft.cryptolitics.adapter.driven.repository.db.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record KLineRecord(
        LocalDateTime startDateTime,
        BigDecimal openPrice,
        BigDecimal highPrice,
        BigDecimal lowPrice,
        BigDecimal closePrice,
        BigDecimal volume,
        BigDecimal turnover
) {
}
