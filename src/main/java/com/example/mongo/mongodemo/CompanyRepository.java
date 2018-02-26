package com.example.mongo.mongodemo;

import com.example.mongo.mongodemo.common.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {

    Company findByName(final String name);
}
