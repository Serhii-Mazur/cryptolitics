package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKlineBybitApiResponse;
import com.tradesoft.cryptolitics.domain.market.KLine;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KLineGraphMapperTest {

    @Test
    public void toDomain_should_map_GetBybitKlineResponse_to_Kline() {
        // Given
        List<String> responseCandleStick = new ArrayList<>();
        responseCandleStick.add(0, "1701090000000");
        responseCandleStick.add(1, "2.4018");
        responseCandleStick.add(2, "2.4064");
        responseCandleStick.add(3, "2.4012");
        responseCandleStick.add(4, "2.406");
        responseCandleStick.add(5, "3869.18");
        responseCandleStick.add(6, "9302.283669");

        List<List<String>> responseCandleSticks = new ArrayList<>();
        responseCandleSticks.add(0, responseCandleStick);

        GetKlineBybitApiResponse.Kline kline = new GetKlineBybitApiResponse.Kline(
                "TONUSDT",
                "spot",
                responseCandleSticks
        );

        KLine KLine = new KLine(
                LocalDateTime.of(2023, 11, 27, 13, 0, 0),
                BigDecimal.valueOf(2.4018),
                BigDecimal.valueOf(2.4064),
                BigDecimal.valueOf(2.4012),
                BigDecimal.valueOf(2.406),
                BigDecimal.valueOf(3869.18),
                BigDecimal.valueOf(9302.283669)
        );
        List<KLine> KLines = new ArrayList<>();
        KLines.add(0, KLine);

        KLineGraph expected = new KLineGraph(
                "TONUSDT",
                KLines
        );

        // When
        KLineGraph actual = KlineMapper.toDomain(kline);

        // Then
        assertEquals(expected, actual);
    }
}