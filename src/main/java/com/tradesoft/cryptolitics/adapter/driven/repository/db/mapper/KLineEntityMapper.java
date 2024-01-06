package com.tradesoft.cryptolitics.adapter.driven.repository.db.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KlineH1Entity;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;

import java.time.LocalDateTime;
import java.util.List;

public class KLineEntityMapper {

    public static KlineH1Entity mapEntity(CoinPair coinPair, KLine kLine) {

        return new KlineH1Entity(
                mapKLineId(coinPair, kLine.startTime()),
                kLine.openPrice(),
                kLine.highPrice(),
                kLine.lowPrice(),
                kLine.closePrice(),
                kLine.volume(),
                kLine.turnover()
        );
    }

    public static KLineGraph mapDomainGraph(List<KlineH1Entity> entities) {

        return new KLineGraph(
                entities.get(0).id().coinPair(),
                entities.stream().map(KLineEntityMapper::mapKLine).toList()
        );
    }

    public static KLine mapKLine(KlineH1Entity entity) {

        return new KLine(
                entity.id().startDateTime(),
                entity.openPrice(),
                entity.highPrice(),
                entity.lowPrice(),
                entity.closePrice(),
                entity.volume(),
                entity.turnover()
        );
    }

    private static KlineH1Entity.KlineId mapKLineId(CoinPair coinPair, LocalDateTime startTime) {

        return new KlineH1Entity.KlineId(coinPair, startTime);
    }
}
