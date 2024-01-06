//package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market;
//
//import com.tradesoft.cryptolitics.exception.ApiErrorException;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//
//public class BybitErrorDecoder implements ErrorDecoder {
//
//    private ErrorDecoder defaultErrorDecoder = new Default();
//
//    private final String BAD_REQUEST_MESSAGE =  "Bad request. Need to send the request with GET / POST (must be capitalized)";
//    private final String UNAUTHORIZED_MESSAGE = "Unauthorized request. 1. Need to use the correct key to access; 2. Need to put authentication params in the request header";
//    private final String FORBIDDEN_MESSAGE =    "Forbidden request. Possible causes: 1. IP rate limit breached; 2. You send GET request with an empty json body; 3. You are using U.S IP";
//    private final String NOT_FOUND_MESSAGE =    "Cannot find path. Possible causes: 1. Wrong path; 2. Category value does not match account mode";
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        String errorMessage = switch (response.status()) {
//            case 400 -> BAD_REQUEST_MESSAGE;
//            case 401 -> UNAUTHORIZED_MESSAGE;
//            case 403 -> FORBIDDEN_MESSAGE;
//            case 404 -> NOT_FOUND_MESSAGE;
//            default -> null;
//        };
//
//        if (errorMessage == null) {
//            return defaultErrorDecoder.decode(methodKey, response);
//        } else {
//            return new ApiErrorException(response.status(), errorMessage);
//        }
//    }
//}
