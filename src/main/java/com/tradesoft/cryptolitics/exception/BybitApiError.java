package com.tradesoft.cryptolitics.exception;

public record BybitApiError(
    int errorCode,
    String errorMessage
) {
}
