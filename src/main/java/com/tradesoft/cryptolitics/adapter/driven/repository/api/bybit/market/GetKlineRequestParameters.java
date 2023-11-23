package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market;

public record GetKlineRequestParameters(
        String category,
        String symbol,
        String interval,
        Long startDateTime,
        Long endDateTime,
        Integer limit
) {
//
//    public GetKlineRequestParameters(
//            String category,
//            String symbol,
//            String interval
//    ) {
//        this(
//                category,
//                symbol,
//                interval,
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty()
//        );
//    }
//
//    public GetKlineRequestParameters(
//            String category,
//            String symbol,
//            String interval,
//            Long startDateTime
//    ) {
//        this(
//                category,
//                symbol,
//                interval,
//                Optional.of(startDateTime),
//                Optional.empty(),
//                Optional.empty()
//        );
//    }
//
//    public GetKlineRequestParameters(
//            String category,
//            String symbol,
//            String interval,
//            Long startDateTime,
//            Integer limit
//    ) {
//        this(
//                category,
//                symbol,
//                interval,
//                Optional.of(startDateTime),
//                Optional.empty(),
//                Optional.of(limit)
//        );
//    }
}
