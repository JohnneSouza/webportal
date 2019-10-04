package br.com.imobiliariaype.vendas.webportal.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

public class AppConfig extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private final String DATABASE_NAME;

    @Autowired
    public AppConfig(String DATABASE_NAME) {
        this.DATABASE_NAME = DATABASE_NAME;
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }
}
