package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetServerTimeBybitApiResponseTest {

    //    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void deserialize() throws JsonProcessingException {
        // Given
        String json = """
                    {
                        "retCode": 0,
                        "retMsg": "OK",
                        "result": {
                            "timeSecond": "1701089470",
                            "timeNano": "1701089470680090967"
                        },
                        "retExtInfo": {},
                        "time": 1701089470680
                    }
                """;

        GetServerTimeBybitApiResponse expected = new GetServerTimeBybitApiResponse(
                0,
                "OK",
                1701089470680L,
                new GetServerTimeBybitApiResponse.ServerTime("1701089470", "1701089470680090967")
        );

        // When
        GetServerTimeBybitApiResponse actual = objectMapper.readValue(json, GetServerTimeBybitApiResponse.class);

        // Then
        assertEquals(expected, actual);
    }
}