package com.ssezer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "poiEntity", propOrder = {
    "id",
    "value",
    "category"
})
public class PoiEntity {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String value;
    @XmlElement(required = true)
    protected String category;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String value) {
        this.category = value;
    }

}
