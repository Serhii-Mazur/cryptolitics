//package com.tradesoft.cryptolitics.adapter.driven.repository.db;
//
//import com.tradesoft.cryptolitics.adapter.driven.repository.db.entity.TestEntity;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Objects;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
////@DataMongoTest
////@DirtiesContext
////@Import(TestRepositoryImpl.class)
////@ActiveProfiles("test")
//class TestRepositoryImplTest {
//
//    private static MongodExecutable mongodExecutable;
//    private static MongoTemplate mongoTemplate;
//
//    @BeforeAll
//    static void setUp() throws IOException {
//        MongodStarter starter = MongodStarter.getDefaultInstance();
//
//        IMongodConfig mongodConfig = new MongodConfigBuilder()
//                .version(Version.Main.PRODUCTION)
//                .net(new Net("localhost", 27017, Network.localhostIsIPv6()))
//                .build();
//
//        mongodExecutable = starter.prepare(mongodConfig);
//        MongodProcess mongod = mongodExecutable.start();
//
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        mongoTemplate = new MongoTemplate(mongoClient, "test");
//    }
//
//    @AfterAll
//    static void tearDown() {
//        if (mongodExecutable != null) {
//            mongodExecutable.stop();
//        }
//    }
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    private TestRepositoryImpl testRepository;
//
//    @DisplayName("Test for save(...) method")
//    @Test
//    void test() {
//        // Given
//        UUID id = UUID.randomUUID();
//        String identificator = String.format("Ident: %s", id);
//        TestEntity entity = new TestEntity(id, identificator, 1);
//
//        // When
//        testRepository.saveOne(entity);
//
//        // Then
//        assertEquals(identificator, Objects.requireNonNull(mongoTemplate.findById(id, TestEntity.class)).getIdentificator());
//    }
//}