package com.tradesoft.cryptolitics.adapter.driven.repository.db;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KlineH1Entity;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.KLineH1MongoRepository;
import com.tradesoft.cryptolitics.application.port.repository.KLineH1Repository;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class KlineRepositoryImplTest {

    private final KLineH1MongoRepository klineMongoRepository = mock();

    private final KLineH1Repository kLineRepository = new KLineH1RepositoryImpl(klineMongoRepository);

    @Test
    void saveAll_should_save_KLines() {
        // Given
        LocalDateTime startDateTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(1703610000000L),
                ZoneId.of("UTC")
        );
        BigDecimal openPrice = new BigDecimal("2.1622");
        BigDecimal highPrice = new BigDecimal("2.1716");
        BigDecimal lowPrice = new BigDecimal("2.15");
        BigDecimal closePrice = new BigDecimal("2.1699");
        BigDecimal volume = new BigDecimal("56954.23");
        BigDecimal turnover = new BigDecimal("123122.729141");
        KLine kLine = new KLine(startDateTime, openPrice, highPrice, lowPrice, closePrice, volume, turnover);
        List<KLine> kLines = List.of(kLine);

        KlineH1Entity entity = new KlineH1Entity(
                new KlineH1Entity.KlineId(CoinPair.BTCUSDT, startDateTime),
                openPrice,
                highPrice,
                lowPrice,
                closePrice,
                volume,
                turnover
        );
        List<KlineH1Entity> entities = List.of(entity);

        when(klineMongoRepository.saveAll(any())).thenReturn(entities);

        // When
        kLineRepository.saveAll(CoinPair.BTCUSDT, kLines);

        // Then
        verify(klineMongoRepository, times(1)).saveAll(entities);
    }

    @Test
    void saveAll_should_throw_an_exception_when_KLines_is_null_or_empty() {
        assertThrows(IllegalStateException.class,
                () -> kLineRepository.saveAll(CoinPair.BTCUSDT, null)
        );
        assertThrows(IllegalStateException.class,
                () -> kLineRepository.saveAll(CoinPair.TONUSDT, Collections.emptyList()));
    }
}