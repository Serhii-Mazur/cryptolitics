package com.tradesoft.cryptolitics.adapter.driven.repository.db.entity;

import lombok.NoArgsConstructor;

//@Document(collection = "spot_k_lines")
@NoArgsConstructor
public class SpotKLineEntity extends KlineEntity {

    public SpotKLineEntity(KlineId id, KLineRecord kLineRecord) {
        super(id, kLineRecord);
    }
}
