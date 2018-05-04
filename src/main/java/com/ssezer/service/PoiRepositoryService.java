package com.ssezer.service;

import com.ssezer.model.Mapper;
import com.ssezer.model.Poi;
import com.ssezer.model.repository.PoiRepository;
import com.ssezer.ws.model.PoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoiRepositoryService {

  private Mapper mapper;
  private PoiRepository poiRepository;

  @Autowired
  public PoiRepositoryService(PoiRepository poiRepository, Mapper mapper){
    this.poiRepository = poiRepository;
    this.mapper = mapper;
  }

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
