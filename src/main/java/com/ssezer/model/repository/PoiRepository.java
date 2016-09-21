package com.ssezer.model.repository;

import com.ssezer.model.Poi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoiRepository extends MongoRepository<Poi, String> {
    List<Poi> findByValue(String value);
}
