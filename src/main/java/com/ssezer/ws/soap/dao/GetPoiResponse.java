//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.05 at 12:11:32 PM EEST 
//


package com.ssezer.ws.soap.dao;

import com.ssezer.ws.model.PoiEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "poiEntity"
})
@XmlRootElement(name = "getPoiResponse")
public class GetPoiResponse {

    @XmlElement(required = true)
    protected List<PoiEntity> poiEntity;

    public List<PoiEntity> getPoiEntity() {
        return poiEntity;
    }

    public void setPoiEntity(List<PoiEntity> value) {
        this.poiEntity = value;
    }

}