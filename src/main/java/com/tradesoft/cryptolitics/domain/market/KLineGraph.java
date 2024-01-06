package com.tradesoft.cryptolitics.domain.market;

import com.tradesoft.cryptolitics.domain.constants.CoinPair;

import java.util.List;

import static java.util.Collections.emptyList;

public record KLineGraph(
        CoinPair coinPair,
        List<KLine> kLines
) {
    public static KLineGraph empty(CoinPair pair) {
        return new KLineGraph(pair, emptyList());
    }
}
