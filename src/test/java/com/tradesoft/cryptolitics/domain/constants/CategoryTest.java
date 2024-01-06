package com.tradesoft.cryptolitics.domain.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @DisplayName("Method getValue(...) should return appropriate enum value")
    @Test
    void get_valid_value() {
        // Given
        String stringValue = "lInEaR";

        Category expected = Category.LINEAR;

        // When
        Category actual = Category.getValue(stringValue);

        // Then
        assertEquals(expected, actual);
    }

    @DisplayName("Method getValue(...) should return UNKNOWN")
    @Test
    void get_unknown_value() {
        // Given
        String stringValue = "test";

        Category expected = Category.UNKNOWN;

        // When
        Category actual = Category.getValue(stringValue);

        // Then
        assertEquals(expected, actual);
    }
}