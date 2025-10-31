package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.domain.ServerTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BybitExchangeMarketRepositoryImplTest {

    @Mock
    private BybitExchangeMarketApiV5 bybitMarketApi;

    @InjectMocks
    private BybitExchangeMarketRepositoryImpl bybitMarketRepository;

    private final Random random = new Random();

    @Test
    void getServerTime_should_return_domain_ServerTime() {
        // Given
        int retCode = 1;
        String retMsg = "OK";
        long time = 1701089470680L;
        GetServerTimeBybitApiResponse serverTimeApiResponse = new GetServerTimeBybitApiResponse(
                retCode,
                retMsg,
                time,
                new GetServerTimeBybitApiResponse.ServerTime(
                        String.valueOf(TimeUnit.MILLISECONDS.toSeconds(time)),
                        String.valueOf(TimeUnit.MILLISECONDS.toNanos(time))
                )
        );
        var expected = new ServerTime(LocalDateTime.of(2023, 11, 27, 13, 51, 10));

        when(bybitMarketApi.getServerTime()).thenReturn(serverTimeApiResponse);

        // When
        var actual = bybitMarketRepository.getServerTime();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void getServerTime_should_throw_exception() {
        // Given
        int retCode = random.nextInt();
        String retMsg = "Server error.";
        long time = 1701089470680L;
        GetServerTimeBybitApiResponse serverTimeApiResponse = new GetServerTimeBybitApiResponse(
                retCode,
                retMsg,
                time,
                new GetServerTimeBybitApiResponse.ServerTime(
                        String.valueOf(TimeUnit.MILLISECONDS.toSeconds(time)),
                        String.valueOf(TimeUnit.MILLISECONDS.toNanos(time))
                )
        );
        var expected = new ServerTime(LocalDateTime.of(2023, 11, 27, 13, 51, 10));

        when(bybitMarketApi.getServerTime()).thenReturn(serverTimeApiResponse);

        // When
        var actual = bybitMarketRepository.getServerTime();

        // Then
        assertEquals(expected, actual);
    }
}
