package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.tradesoft.cryptolitics.exception.BybitApiException;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseBybitApiResponseTest {
    Random random = new Random();

    record BybitApiResponseTest(
            int retCode,
            String retMsg,
            long time
    ) implements BaseBybitApiResponse {
    }

    @Test
    void validate_should_pass_when_retCode_is_equal_to_zero() throws BybitApiException {
        // Given
        int retCode = 0;
        String retMsg = "";

        BaseBybitApiResponse testInstance = new BybitApiResponseTest(retCode, retMsg, 0);

        // When
        testInstance.validate();

        // Then
        assertEquals(0, testInstance.retCode());
        assertEquals("", testInstance.retMsg());
    }

    @Test
    void validate_should_throw_exception_when_retcode_equals_to_zero() {
        // Given
        int retCode = random.nextInt(1, 3501000);
        String retMsg = "Error description";

        BaseBybitApiResponse testInstance = new BybitApiResponseTest(retCode, retMsg, 0);

        String expectedMessage = "Error description";

        // When
        var actual = assertThrows(BybitApiException.class, testInstance::validate);

        // Then
        assertEquals(expectedMessage, actual.getMessage());
    }
}