package com.exastax.ws.rest;

import com.exastax.service.endpoint.PoiRestEndpoint;
import com.exastax.ws.model.PoiEntity;
import com.exastax.ws.model.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EntityServiceImpl implements EntityService {

    @Autowired
    private PoiRestEndpoint poiRestEndPoint;

    @Override
    public ResponseEntity getEntities(@PathVariable(value = "query") String query, @RequestParam(value = "limit") Optional<Integer> limit) {
        List<PoiEntity> entities = poiRestEndPoint.getEntities(query, limit);
        ServiceResponse response = new ServiceResponse(entities, true, "ok");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveEntity(@PathVariable("entityId") String id, @RequestBody PoiEntity entity) {
        if (entity != null) {
            if (entity.getId() == null) {
                entity.setId(id);
            }

            PoiEntity returnEntity = poiRestEndPoint.saveEntity(entity);
            if (returnEntity != null) {
                ServiceResponse response = new ServiceResponse(returnEntity, true, "ok");
                return new ResponseEntity(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity updateEntity(@PathVariable("entityId") String id, @RequestBody PoiEntity entity) {
        if (entity != null) {

            if (entity.getId() == null) {
                entity.setId(id);
            }

            PoiEntity returnEntity = poiRestEndPoint.saveEntity(entity);
            if (returnEntity != null) {
                ServiceResponse response = new ServiceResponse(returnEntity, true, "saved from update endpoint");
                return new ResponseEntity(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity deleteEntity(@PathVariable(value = "entityId") String entityId) {
        boolean result = poiRestEndPoint.deleteEntity(entityId);
        if (result) {
            ServiceResponse response = new ServiceResponse(true, entityId + " deleted.");
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
