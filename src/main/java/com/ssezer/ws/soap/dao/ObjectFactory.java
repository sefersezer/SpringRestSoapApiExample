package com.ssezer.ws.soap.dao;

import com.ssezer.ws.model.PoiEntity;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public SavePoiRequest createSavePoiRequest() {
        return new SavePoiRequest();
    }

    public PoiEntity createPoiEntity() {
        return new PoiEntity();
    }

    public GetPoiRequest createGetPoiRequest() {
        return new GetPoiRequest();
    }

    public DeletePoiRequest createDeletePoiRequest() {
        return new DeletePoiRequest();
    }

    public GetPoiResponse createGetPoiResponse() {
        return new GetPoiResponse();
    }

}
