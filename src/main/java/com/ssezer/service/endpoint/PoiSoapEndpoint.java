package com.ssezer.service.endpoint;

import com.ssezer.service.PoiRepositoryService;
import com.ssezer.ws.model.PoiEntity;
import com.ssezer.ws.soap.dao.SavePoiRequest;
import com.ssezer.ws.soap.dao.DeletePoiRequest;
import com.ssezer.ws.soap.dao.GetPoiRequest;
import com.ssezer.ws.soap.dao.GetPoiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class PoiSoapEndpoint {

    private final static String NAMESPACE_URI = "http://localhost:9000"; // TODO set parametric

    @Autowired
    private PoiRepositoryService poiRepositoryService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPoiRequest")
    @ResponsePayload
    public GetPoiResponse getPoiResponse(@RequestPayload GetPoiRequest request) {
        GetPoiResponse response = new GetPoiResponse();
        response.setPoiEntity(poiRepositoryService.findByValue(request.getValue()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "savePoiRequest")
    @ResponsePayload
    public GetPoiResponse savePoiRequest(@RequestPayload SavePoiRequest request) {
        GetPoiResponse response = new GetPoiResponse();
        poiRepositoryService.save(request.getPoiEntity());
        response.setPoiEntity(mapList(request.getPoiEntity()));
        return response;
    }

    private List<PoiEntity> mapList(PoiEntity poiEntity) {
        List<PoiEntity> entities = new ArrayList<>();
        entities.add(poiEntity);
        return entities;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePoiRequest")
    @ResponsePayload
    public GetPoiResponse deletePoiRequest(@RequestPayload DeletePoiRequest request) {
        GetPoiResponse response = new GetPoiResponse();
        poiRepositoryService.delete(request.getPoiEntity());
        response.setPoiEntity(mapList(request.getPoiEntity()));
        return response;
    }

}
