package com.tradesoft.cryptolitics.basetest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class BaseMockTest {

    @Autowired
    protected ObjectMapper objectMapper;

    protected WireMockServer wireMockServer;

    @BeforeEach
    public void setUp() {
        wireMockServer = new WireMockServer(9999);
        wireMockServer.start();
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }

    public void mockGet(
            String url,
            Object responseObject,
            HttpStatus status
//            int httpStatusCode
    ) {
        try {
            wireMockServer.stubFor(
                    WireMock.get(WireMock.urlEqualTo(url))
                            .willReturn(
                                    WireMock.aResponse()
                                            .withStatus(status.value())
                                            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                            .withBody(resolveResponse(responseObject))
                            )
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String resolveResponse(Object responseObject) throws JsonProcessingException {
        String result;
        if (responseObject instanceof String) {
            result = (String) responseObject;
        } else {
            result = objectMapper.writeValueAsString(responseObject);
        }

        return result;
    }
}
