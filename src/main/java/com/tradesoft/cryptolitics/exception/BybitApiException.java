package com.tradesoft.cryptolitics.exception;

import lombok.Getter;

@Getter
public class BybitApiException extends RuntimeException {
    private BybitApiError error;

    public BybitApiException(BybitApiError error) {
        this.error = error;
    }

    public BybitApiException() {
        super();
    }

    public BybitApiException(String message) {
        super(message);
    }

    public BybitApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BybitApiException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.errorMessage();
        } else {
            return super.getMessage();
        }
    }
}
