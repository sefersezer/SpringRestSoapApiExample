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


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poiEntity" type="{http://localhost:9000}poiEntity"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "poiEntity"
})
@XmlRootElement(name = "savePoiRequest")
public class SavePoiRequest {

    @XmlElement(required = true)
    protected PoiEntity poiEntity;

    /**
     * Gets the value of the poiEntity property.
     * 
     * @return
     *     possible object is
     *     {@link PoiEntity }
     *     
     */
    public PoiEntity getPoiEntity() {
        return poiEntity;
    }

    /**
     * Sets the value of the poiEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PoiEntity }
     *     
     */
    public void setPoiEntity(PoiEntity value) {
        this.poiEntity = value;
    }

}
