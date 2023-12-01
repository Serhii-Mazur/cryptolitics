package com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.KlineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KLineMongoRepository extends MongoRepository<KlineEntity, String> {
}
