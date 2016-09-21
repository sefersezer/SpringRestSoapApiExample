package com.ssezer.ws.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ServiceResponse implements Serializable {

    @Getter
    @Setter
    private List<PoiEntity> entities;

    @Getter
    @Setter
    private boolean status;

    @Getter
    @Setter
    private String developerComment;

    public ServiceResponse(PoiEntity entity) {
        if (entity == null) {
            return;
        }
        if (entities == null) {
            entities = new ArrayList<>();
        } else {
            entities.clear();
        }
        entities.add(entity);
    }

    public ServiceResponse(List<PoiEntity> entities) {
        this.entities = entities;
    }

    public ServiceResponse() {

    }

    public ServiceResponse(List<PoiEntity> entity, boolean status, String developerComment) {
        this(entity);
        setParams(status, developerComment);
    }

    public ServiceResponse(boolean status, String developerComment) {
        setParams(status, developerComment);
    }

    private void setParams(boolean status, String developerComment) {
        this.status = status;
        this.developerComment = developerComment;
    }

    public ServiceResponse(PoiEntity entity, boolean status, String developerComment) {
        this(entity);
        setParams(status, developerComment);
    }
}
