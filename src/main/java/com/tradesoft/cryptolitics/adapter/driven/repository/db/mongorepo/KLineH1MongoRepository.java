package com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KlineH1Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KLineH1MongoRepository extends MongoRepository<KlineH1Entity, String> {
}
