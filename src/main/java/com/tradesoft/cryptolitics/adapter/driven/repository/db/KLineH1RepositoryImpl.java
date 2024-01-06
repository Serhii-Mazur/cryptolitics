package com.tradesoft.cryptolitics.adapter.driven.repository.db;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.mapper.KLineEntityMapper;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.KLineH1MongoRepository;
import com.tradesoft.cryptolitics.application.port.repository.KLineH1Repository;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class KLineH1RepositoryImpl implements KLineH1Repository {

    private final KLineH1MongoRepository kLineMongoRepository;


    @Autowired
    public KLineH1RepositoryImpl(KLineH1MongoRepository kLineMongoRepository) {
        this.kLineMongoRepository = kLineMongoRepository;
    }

    @Override
    public void saveAll(CoinPair coinPair, List<KLine> kLines) throws IllegalStateException {
        if (kLines == null || kLines.isEmpty()) {

            throw new IllegalStateException(String.format("Attempt to save empty or null KLine list! Coin Pair:[%s]", coinPair));
        } else {
            kLineMongoRepository.saveAll(kLines
                    .stream()
                    .map((KLine kLine) -> KLineEntityMapper.mapEntity(coinPair, kLine))
                    .collect(Collectors.toList())
            );
        }
    }
}
