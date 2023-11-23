package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit;

public enum BybitInterval {
    M1("1"),
    M3("3"),
    M5("5"),
    M15("15"),
    M30("30"),
    H1("60"),
    H2("120"),
    H4("240"),
    H6("360"),
    H12("720"),
    D1("D"),
    W1("W"),
    M("M");

    public final String bybitInterval;

    BybitInterval(String bybitInterval) {
        this.bybitInterval = bybitInterval;
    }
}
