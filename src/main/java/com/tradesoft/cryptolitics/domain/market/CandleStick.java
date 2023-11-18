package com.tradesoft.cryptolitics.domain.market;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CandleStick(
        LocalDateTime startTime,    // Start time of the candle. UTC
        BigDecimal openPrice,       // Open price
        BigDecimal highPrice,       // Highest price
        BigDecimal lowPrice,        // Lowest price
        BigDecimal closePrice,      // Close price. Is the last traded price when the candle is not closed
        BigDecimal volume,          // Trade volume. Unit of contract: pieces of contract. Unit of spot: quantity of coins
        BigDecimal turnover         // Turnover. Unit of figure: quantity of quota coin
) {
}
