package com.ssotom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ssotom.model.SensorData;

public interface SensorDataRepository extends MongoRepository<SensorData, String>{

}
