//package com.tradesoft.cryptolitics.adapter.driven.repository.db;
//
//import com.tradesoft.cryptolitics.adapter.driven.repository.db.mongorepo.KlineMongoRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Testcontainers
////@DataMongoTest
////@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour
//public class KlineRepositoryImplTest {
//
////    @Container
////    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
//
//    @Container
//    @ServiceConnection
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:6.0")).withExposedPorts(27017);
//
////    @DynamicPropertySource
////    static void mongoDbProperties(DynamicPropertyRegistry registry) {
//
////        mongoDBContainer.start();
////        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
////    }
//
//    @Autowired
//    private KlineMongoRepository klineMongoRepository;
//
//    @Test
//    void test() {
//        // Given
//
//        // When
//
//        // Then
//        assertTrue(true);
//    }
//}