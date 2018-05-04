package com.ssezer.service.endpoint;

import com.ssezer.service.PoiRepositoryService;
import com.ssezer.ws.model.PoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Endpoint
public class PoiRestEndpoint {

  private PoiRepositoryService poiRepositoryService;
  private List<PoiEntity> getEntities(String query) {
    return poiRepositoryService.findByValue(query);
  }

  @Autowired
  public PoiRestEndpoint(PoiRepositoryService poiRepositoryService) {
    this.poiRepositoryService = poiRepositoryService;
  }

  /**
   * zaten yanlış bir yaklaşım. burada pagination kullanılmalıydı. bu yüzden for loop'a karışmadım.
   */
  public List<PoiEntity> getEntities(String query, Integer limit) {
    List<PoiEntity> entities = getEntities(query);

    if (limit> 0 && entities.size() > limit) {
      List<PoiEntity> restrictedList = new ArrayList<>();
      for (AtomicInteger i = new AtomicInteger(0); i.get() < limit; i.incrementAndGet()) {
        restrictedList.add(entities.get(i.get()));
      }
      entities = restrictedList;

    }
    return entities;
  }


  public PoiEntity saveEntity(PoiEntity poiEntity) {
    if (StringUtils.isEmpty(poiEntity.getValue().trim())) {
      return null;
    }
    return poiRepositoryService.save(poiEntity);
  }

  public boolean deleteEntity(String entityId) {
    PoiEntity checkEntity = poiRepositoryService.findById(entityId);
    if (checkEntity != null) {
      poiRepositoryService.delete(checkEntity);
      return true;
    }
    return false;

  }
}
