package com.tradesoft.cryptolitics.adapter.driven.repository.db.mapper;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KLineRecord;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KlineEntity;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.SpotKLineEntity;
import com.tradesoft.cryptolitics.domain.market.KLine;

import java.time.LocalDateTime;

public class SpotKlineEntityMapper {

//    public static KLine toDomain(KlineEntity kLineEntity) {
//
//        KLineRecord kLineRecord = kLineEntity.getKLine();
//
//        return new KLine(
//                kLineRecord.startDateTime(),
//                kLineRecord.openPrice(),
//                kLineRecord.highPrice(),
//                kLineRecord.lowPrice(),
//                kLineRecord.closePrice(),
//                kLineRecord.volume(),
//                kLineRecord.turnover()
//        );
//    }

    public static SpotKLineEntity toEntity(String coinPair, KLine kLine) {

        return new SpotKLineEntity(
                mapKLineId(coinPair, kLine.startTime()),
                mapKLineRecord(kLine)
        );
    }

//    public static KLine mapKLine(KLineRecord kLineRecord) {
//
//        return
//    }

    public static KlineEntity.KlineId mapKLineId(String coinPair, LocalDateTime startTime) {

        return new KlineEntity.KlineId(coinPair, startTime);
    }

    public static KLineRecord mapKLineRecord(KLine kLine) {

        return new KLineRecord(
                kLine.startTime(),
                kLine.openPrice(),
                kLine.highPrice(),
                kLine.lowPrice(),
                kLine.closePrice(),
                kLine.volume(),
                kLine.turnover()
        );
    }
}
