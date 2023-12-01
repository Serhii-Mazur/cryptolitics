package com.tradesoft.cryptolitics.adapter.driven.repository.db;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.mapper.SpotKlineEntityMapper;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.KLineMongoRepository;
import com.tradesoft.cryptolitics.application.port.KLineRepository;
import com.tradesoft.cryptolitics.domain.market.KLine;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class KLineRepositoryImpl implements KLineRepository {

    private final KLineMongoRepository kLineMongoRepository;

    @Autowired
    public KLineRepositoryImpl(KLineMongoRepository kLineMongoRepository) {
        this.kLineMongoRepository = kLineMongoRepository;
    }

    @Override
    public void saveAll(String coinPair, @NotNull List<KLine> kLines) {
        kLineMongoRepository.saveAll(kLines
                .stream()
                .map((KLine kLine) -> SpotKlineEntityMapper.toEntity(coinPair, kLine))
                .collect(Collectors.toList())
        );
    }
}
