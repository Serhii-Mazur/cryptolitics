//package com.tradesoft.cryptolitics.adapter.driven.repository.db;
//
//import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.TestEntity;
//import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.TestMongoRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataMongoTest
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//public class MongoRepoTest {
//
//    @Autowired
//    private TestMongoRepository testMongoRepository;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @DisplayName("given object to save"
//            + " when save object using MongoDB template"
//            + " then object is saved")
//    @Test
//    void testFindByUsername() {
//        // Given
//        UUID id = UUID.randomUUID();
//        String identificator = String.format("ID: %s", id);
//        Integer value = 123;
//        TestEntity entity = new TestEntity(
//                id,
//                identificator,
//                value
//        );
//        testMongoRepository.save(entity);
//
//        // When
//        TestEntity actual = mongoTemplate.findById(id, TestEntity.class);
//
//        // Then
//        assertEquals(value, actual.getValue());
//    }
//}
