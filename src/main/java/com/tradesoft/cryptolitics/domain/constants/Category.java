package com.tradesoft.cryptolitics.domain.constants;

public enum Category {
    SPOT,
    LINEAR,
    INVERSE,
    UNKNOWN;

    public static Category getValue(String stringValue) {
        Category value;
        try {
            value = Category.valueOf(stringValue.toUpperCase());
        } catch (IllegalArgumentException ex) {
            value = Category.UNKNOWN;
        }

        return value;
    }
}
