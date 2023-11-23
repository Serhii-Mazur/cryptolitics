package com.tradesoft.cryptolitics.adapter.driven.repository.bybit;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.BybitExchangeMarketApiV5;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKlineBybitApiResponse;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.basetest.BaseMockTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for BybitExchangeMarketApiV5")
@SpringBootTest
@ActiveProfiles("test")
public class BybitExchangeMarketApiV5Test extends BaseMockTest {

    @Autowired
    private BybitExchangeMarketApiV5 bybitExchangeMarketApiV5;

    @Test
    public void getServerTime_should_return_Bybit_server_time() {
        // Given
        String url = "/v5/market/time";
        String responseObject = """
                    {
                        "retCode": 0,
                        "retMsg": "OK",
                        "result": {
                            "timeSecond": "1697469632",
                            "timeNano": "1697469632991732642"
                        },
                        "retExtInfo": {},
                        "time": 1697469632991
                    }
                """;
        mockGet(url, responseObject, HttpStatus.OK);

        GetServerTimeBybitApiResponse expected = new GetServerTimeBybitApiResponse(
                0,
                "OK",
                1697469632991L,
                new GetServerTimeBybitApiResponse.ServerTime("1697469632", "1697469632991732642")
        );

        // When
        GetServerTimeBybitApiResponse actual = bybitExchangeMarketApiV5.getServerTime();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getKlineBybitApiResponse_should_return_Bybit_Kline() {
        // Given
        String category = "spot";
        String symbol = "TONUSDT";
        String interval = "5";
        long start = 1697483400000L;
        long end = 1697483500000L;
        int limit = 1;
        String url = "/v5/market/kline?category=spot&symbol=TONUSDT&interval=5&start=1697483400000&end=1697483500000&limit=1";
        List<String> candle = List.of(
                "1697483400000",
                "1.9514",
                "1.9514",
                "1.9499",
                "1.9499",
                "282.03",
                "549.961041"
        );
        String responseObject = """
                    {
                        "retCode": 0,
                        "retMsg": "OK",
                        "result": {
                            "category": "spot",
                            "symbol": "TONUSDT",
                            "list": [
                                [
                                    "1697483400000",
                                    "1.9514",
                                    "1.9514",
                                    "1.9499",
                                    "1.9499",
                                    "282.03",
                                    "549.961041"
                                ]
                            ]
                        },
                        "retExtInfo": {},
                        "time": 1697483516959
                    }
                """;
        mockGet(url, responseObject, HttpStatus.OK);

        GetKlineBybitApiResponse expected = new GetKlineBybitApiResponse(
                0,
                "OK",
                1697483516959L,
                new GetKlineBybitApiResponse.Kline(
                        "TONUSDT",
                        "spot",
                        List.of(candle)
                )
        );

        // When
        GetKlineBybitApiResponse actual = bybitExchangeMarketApiV5.getKline(category, symbol, interval, start, end, limit);

        // Then
        assertEquals(expected, actual);
    }

//    @Test
//    public void getKlineBybitApiResponse_should_return_Bybit_Kline_wo_start_end_params() {
//        // Given
//        String category = "spot";
//        String symbol = "TONUSDT";
//        String interval = "5";
//        int limit = 1;
//        String url = "/v5/market/kline?category=spot&symbol=TONUSDT&interval=5&limit=1";
//        List<String> candle = List.of(
//                "1697483400000",
//                "1.9514",
//                "1.9514",
//                "1.9499",
//                "1.9499",
//                "282.03",
//                "549.961041"
//        );
//        String responseObject = """
//                    {
//                        "retCode": 0,
//                        "retMsg": "OK",
//                        "result": {
//                            "category": "spot",
//                            "symbol": "TONUSDT",
//                            "list": [
//                                [
//                                    "1697483400000",
//                                    "1.9514",
//                                    "1.9514",
//                                    "1.9499",
//                                    "1.9499",
//                                    "282.03",
//                                    "549.961041"
//                                ]
//                            ]
//                        },
//                        "retExtInfo": {},
//                        "time": 1697483516959
//                    }
//                """;
//        mockGet(url, responseObject, HttpStatus.OK);
//
//        GetKlineBybitApiResponse expected = new GetKlineBybitApiResponse(
//                0,
//                "OK",
//                1697483516959L,
//                new GetKlineBybitApiResponse.Kline(
//                        "TONUSDT",
//                        "spot",
//                        List.of(candle)
//                )
//        );
//
//        // When
//        GetKlineBybitApiResponse actual = bybitExchangeMarketApiV5.getKline(category, symbol, interval, limit);
//
//        // Then
//        assertEquals(expected, actual);
//    }
}