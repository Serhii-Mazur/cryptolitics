package com.tradesoft.cryptolitics.application.port.repository;

import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;

import java.util.List;

public interface KLineH1Repository {

    void saveAll(CoinPair coinPair, List<KLine> kLines) throws IllegalStateException;
}
