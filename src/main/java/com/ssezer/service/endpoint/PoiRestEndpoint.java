package com.ssezer.service.endpoint;

import com.ssezer.service.PoiRepositoryService;
import com.ssezer.ws.model.PoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Endpoint
public class PoiRestEndpoint {

    @Autowired
    private PoiRepositoryService poiRepositoryService;

    public List<PoiEntity> getEntities(String query) {
        List<PoiEntity> entities = poiRepositoryService.findByValue(query);
        return entities;
    }

    public List<PoiEntity> getEntities(String query, Optional<Integer> limit) {
        List<PoiEntity> entities = getEntities(query);

        if (limit.isPresent() && limit.get() > 0 && entities.size() > limit.get()) {
            List<PoiEntity> restrictedList = new ArrayList<>();
            for (AtomicInteger i = new AtomicInteger(0); i.get() < limit.get(); i.incrementAndGet()) {
                restrictedList.add(entities.get(i.get()));
            }
            entities = restrictedList;
        }
        return entities;
    }


    public PoiEntity saveEntity(PoiEntity poiEntity) {
        if (poiEntity.getValue() == null || "".equals(poiEntity.getValue().trim())) {
            return null;
        }
        return poiRepositoryService.save(poiEntity);
    }

    public boolean deleteEntity(String entityId) {
        PoiEntity checkEntity = poiRepositoryService.findById(entityId);
        if (checkEntity != null) {
            poiRepositoryService.delete(checkEntity);
            return true;
        } else {
            return false;
        }
    }
}
