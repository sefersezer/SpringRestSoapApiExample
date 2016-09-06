package com.exastax.service;

import com.exastax.model.Mapper;
import com.exastax.model.Poi;
import com.exastax.model.repository.PoiRepository;
import com.exastax.ws.model.PoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoiRepositoryService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private PoiRepository poiRepository;

    public PoiEntity save(PoiEntity poiEntity) {
        Poi saved = poiRepository.save(mapper.mapPoiDTO(poiEntity));
        if (saved != null) {
            return mapper.mapPoi(saved);
        }
        return null;
    }

    public List<PoiEntity> findByValue(String value) {
        List<Poi> found = poiRepository.findByValue(value);
        if (found != null) {
            return mapper.mapPoiList(found);
        }
        return new ArrayList<>();
    }

    public void delete(PoiEntity poiEntity) {
        poiRepository.delete(mapper.mapPoiDTO(poiEntity));
    }

    public PoiEntity findById(String entityId) {
        Poi found = poiRepository.findOne(entityId);
        if (found != null) {
            return mapper.mapPoi(found);
        }
        return null;
    }
}
