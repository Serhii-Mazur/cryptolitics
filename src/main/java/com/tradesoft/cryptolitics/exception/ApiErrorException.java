package com.tradesoft.cryptolitics.exception;

public class ApiErrorException extends Exception {
    public Integer httpStatus;
    public String errorMessage;

    public ApiErrorException(Integer httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
