package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.tradesoft.cryptolitics.exception.BybitApiError;
import com.tradesoft.cryptolitics.exception.BybitApiException;

public interface BaseBybitApiResponse {

    int retCode();
    String retMsg();
    long time();

    default void validate() throws BybitApiException {
        if (retCode() != 0) {
            BybitApiError apiError = new BybitApiError(retCode(), retMsg());
            throw new BybitApiException(apiError);
        }
    }
}
