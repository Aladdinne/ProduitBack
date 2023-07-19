package com.example.productstage.Repository;

import com.example.productstage.Collections.Product;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface ProductRepository extends MongoRepository<Product, String> {
}
