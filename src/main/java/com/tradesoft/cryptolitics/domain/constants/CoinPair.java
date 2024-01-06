package com.tradesoft.cryptolitics.domain.constants;

public enum CoinPair {
    BTCUSDT,
    ETHUSDT,
    TONUSDT,
    UNKNOWN;    // Used for unknown coin pairs

    public  static CoinPair getValue(String stringValue) {
        CoinPair value;
        try {
            value = CoinPair.valueOf(stringValue.toUpperCase());
        } catch (IllegalArgumentException ex) {
            value = CoinPair.UNKNOWN;
        }

        return value;
    }
}
