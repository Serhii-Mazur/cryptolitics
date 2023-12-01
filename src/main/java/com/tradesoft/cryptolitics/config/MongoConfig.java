package com.tradesoft.cryptolitics.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("!test")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String dbName;
    @Value("${spring.data.mongodb.host}")
    private String dbHost;
    @Value("${spring.data.mongodb.port}")
    private String dbPort;

    private final String MONGO_DB = "mongodb";

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient mongoClient() {
        String connString = new StringBuilder()
                .append(MONGO_DB).append("://")
                .append(dbHost).append(":")
                .append(dbPort).append("/")
                .append(dbName)
                .toString();

        ConnectionString connectionString = new ConnectionString(connString);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .applyConnectionString(connectionString).build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
