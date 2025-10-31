package com.tradesoft.cryptolitics.adapter.driven.repository.db;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KlineH1Entity;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.KLineH1MongoRepository;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class KLineH1RepositoryImplTest {

    @Mock
    private KLineH1MongoRepository kLineMongoRepository;

    @InjectMocks
    private KLineH1RepositoryImpl kLineRepository;

    @Test
    void saveAll_should_save_KLines() {
        // Given
        LocalDateTime startDateTime = LocalDateTime.of(2023, 11, 27, 13, 51, 10);
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

        when(kLineMongoRepository.saveAll(any())).thenReturn(entities);

        // When
        kLineRepository.saveAll(CoinPair.BTCUSDT, kLines);

        // Then
        verify(kLineMongoRepository, times(1)).saveAll(any());
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