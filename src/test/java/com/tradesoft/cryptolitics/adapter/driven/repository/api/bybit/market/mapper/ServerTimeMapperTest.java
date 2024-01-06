package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.domain.ServerTime;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class ServerTimeMapperTest {
    @Test
    void toDomain_should_return_domain_ServerTime() {
        // Given
        int retCode = 0;
        String retMsg = "OK";
        long time = 1701089470680L;
        GetServerTimeBybitApiResponse apiResponse = new GetServerTimeBybitApiResponse(
                retCode,
                retMsg,
                time,
                new GetServerTimeBybitApiResponse.ServerTime(
                        String.valueOf(TimeUnit.MILLISECONDS.toSeconds(time)),
                        String.valueOf(TimeUnit.MILLISECONDS.toNanos(time))
                )
        );

        var expected = new ServerTime(LocalDateTime.of(2023, 11, 27, 14, 51, 10));


        MockedStatic<ZoneId> zoneId = mockStatic(ZoneId.class);
        zoneId.when(ZoneId::systemDefault).thenReturn(ZoneOffset.ofHours(2));

        // When
        var actual = ServerTimeMapper.toDomain(apiResponse);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void toDomain_shouldThrowExceptionForNullApiResponse() {
        // Arrange
        GetServerTimeBybitApiResponse apiResponseMock = null;

        // Act and Assert
        assertThrows(IllegalStateException.class,
                () -> ServerTimeMapper.toDomain(apiResponseMock));
    }
}