package com.tradesoft.cryptolitics.domain.market;

import java.util.List;

public record KLineGraph(
        String coinPair,
        List<KLine> kLines
) {
}
