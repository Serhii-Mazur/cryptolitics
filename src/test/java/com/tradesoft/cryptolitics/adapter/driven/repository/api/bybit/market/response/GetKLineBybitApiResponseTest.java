package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GetKLineBybitApiResponseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deserialize() throws JsonProcessingException {
        // Given
        String json = """
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
        List<String> kLine = List.of(
                "1697483400000",
                "1.9514",
                "1.9514",
                "1.9499",
                "1.9499",
                "282.03",
                "549.961041"
        );
        GetKLineBybitApiResponse expected = new GetKLineBybitApiResponse(
                0,
                "OK",
                1697483516959L,
                new GetKLineBybitApiResponse.KLine(
                        "TONUSDT",
                        "spot",
                        List.of(kLine)
                )
        );

        // When
        var actual = objectMapper.readValue(json, GetKLineBybitApiResponse.class);

        // Then
        assertEquals(expected, actual);
    }
}