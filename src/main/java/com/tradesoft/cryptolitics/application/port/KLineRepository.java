package com.tradesoft.cryptolitics.application.port;

import com.tradesoft.cryptolitics.domain.market.KLine;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface KLineRepository {

    void saveAll(String coinPair, @NotNull List<KLine> kLines);
}
