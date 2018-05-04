package com.ssezer.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

@Configuration // Note : bu annotation file read için değil, mongodb için gerekli.
@EnableMongoRepositories(basePackages = "com.ssezer.model.repository")
public class MongoConfig extends AbstractMongoConfiguration {

  private Environment environment;

  @Autowired
  public MongoConfig(Environment environment) {
    this.environment = environment;
  }

  @Override
  public String getDatabaseName() {
    return environment.getProperty("mongodb.name");
  }

  @Bean
  @Override
  public Mongo mongo() {
    return new MongoClient(singletonList(new ServerAddress(environment.getProperty("mongodb.host"), Integer.parseInt(environment.getProperty("mongodb.port")))));
  }

}
