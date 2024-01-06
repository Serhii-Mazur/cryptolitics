package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GetServerTimeBybitApiResponseTest {

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

    @Test
    public void serialize() throws JsonProcessingException {
        // Given
        int retCode = 0;
        String retMsg = "OK";
        long time = 1701089470680L;
        GetServerTimeBybitApiResponse model = new GetServerTimeBybitApiResponse(
                retCode,
                retMsg,
                time,
                new GetServerTimeBybitApiResponse.ServerTime(
                        String.valueOf(TimeUnit.MILLISECONDS.toSeconds(time)),
                        String.valueOf(TimeUnit.MILLISECONDS.toNanos(time))
                )
        );

        String expected = """
                    {\
                    "retCode": 0,\
                    "retMsg": "OK",\
                    "time": 1701089470680,\
                    "result": {\
                        "timeSecond": "1701089470",\
                        "timeNano": "1701089470680000000"\
                    }\
                    }"""
                .replace(": ", ":")
                .replace("    \"", "\"");

        // When
        String actual = objectMapper.writeValueAsString(model);

        // Then
        assertEquals(expected, actual);
    }
}