package com.example.productstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.mapstruct.factory.Mappers;
@SpringBootApplication
@EnableMongoRepositories
public class ProductStageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductStageApplication.class, args);
    }

}
