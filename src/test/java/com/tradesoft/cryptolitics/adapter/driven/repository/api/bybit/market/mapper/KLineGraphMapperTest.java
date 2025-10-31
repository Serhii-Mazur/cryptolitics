package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKLineBybitApiResponse;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KLineGraphMapperTest {
    @Test
    public void toDomain_should_map_GetBybitKlineResponse_to_Kline() {
        // Given
        List<String> responseKLineValues = new ArrayList<>();
        responseKLineValues.add(0, "1701090000000");
        responseKLineValues.add(1, "2.4018");
        responseKLineValues.add(2, "2.4064");
        responseKLineValues.add(3, "2.4012");
        responseKLineValues.add(4, "2.406");
        responseKLineValues.add(5, "3869.18");
        responseKLineValues.add(6, "9302.283669");

        List<List<String>> responseKLines = new ArrayList<>();
        responseKLines.add(responseKLineValues);

        GetKLineBybitApiResponse.KLine responseKLine = new GetKLineBybitApiResponse.KLine(
                "TONUSDT",
                "spot",
                responseKLines
        );

        KLine kLine = new KLine(
                LocalDateTime.of(2023, 11, 27, 14, 0, 0),
                BigDecimal.valueOf(2.4018),
                BigDecimal.valueOf(2.4064),
                BigDecimal.valueOf(2.4012),
                BigDecimal.valueOf(2.406),
                BigDecimal.valueOf(3869.18),
                BigDecimal.valueOf(9302.283669)
        );
        List<KLine> kLines = new ArrayList<>();
        kLines.add(kLine);

        KLineGraph expected = new KLineGraph(
                CoinPair.TONUSDT,
                kLines
        );

        // When
        KLineGraph actual = KlineGraphMapper.toDomain(responseKLine);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void toDomain_should_return_empty_KLineGraph_when_emptyKLine_in_DTO() {
        // Given
        GetKLineBybitApiResponse dto = mock(GetKLineBybitApiResponse.class);
        GetKLineBybitApiResponse.KLine kLine = new GetKLineBybitApiResponse.KLine("BTCUSDT", "spot", Collections.emptyList());

        var expected = KLineGraph.empty(CoinPair.BTCUSDT);

        when(dto.result()).thenReturn(kLine);

        // When
        var actual = KlineGraphMapper.toDomain(dto.result());

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void toDomain_shouldThrowExceptionForNullApiResponse() {
        // Given
        GetKLineBybitApiResponse.KLine apiResponseMock = null;

        // Then
        assertThrows(IllegalStateException.class,
                () -> KlineGraphMapper.toDomain(apiResponseMock));
    }
}
