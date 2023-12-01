package com.tradesoft.cryptolitics.adapter.driven.repository.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "kline")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KlineEntity {
    @Id
    public KlineId id;
    public KLineRecord kLine;

    public record KlineId(
            String coinPair,
            LocalDateTime startDateTime
    ) {
    }
}


