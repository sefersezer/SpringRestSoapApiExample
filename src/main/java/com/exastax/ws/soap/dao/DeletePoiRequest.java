//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.05 at 12:11:32 PM EEST 
//


package com.exastax.ws.soap.dao;

import com.exastax.ws.model.PoiEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "poiEntity"
})
@XmlRootElement(name = "deletePoiRequest")
public class DeletePoiRequest {

    @XmlElement(required = true)
    protected PoiEntity poiEntity;

    public PoiEntity getPoiEntity() {
        return poiEntity;
    }


    public void setPoiEntity(PoiEntity value) {
        this.poiEntity = value;
    }

}