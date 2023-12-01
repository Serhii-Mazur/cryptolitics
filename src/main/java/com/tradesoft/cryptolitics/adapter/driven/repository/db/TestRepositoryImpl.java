//package com.tradesoft.cryptolitics.adapter.driven.repository.db;
//
//import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.TestEntity;
//import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.TestMongoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public class TestRepositoryImpl {
//    private final TestMongoRepository testMongoRepository;
//
//    @Autowired
//    public TestRepositoryImpl(TestMongoRepository testMongoRepository) {
//        this.testMongoRepository = testMongoRepository;
//    }
//
//    public void saveOne(TestEntity entity) {
//        testMongoRepository.save(entity);
//    }
//
//    public TestEntity getById(UUID id) {
//
//        return testMongoRepository.findById(id)
//                .orElse(null); // TODO: Return empty object
//    }
//}
