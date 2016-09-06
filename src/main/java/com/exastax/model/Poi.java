package com.exastax.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Document(collection = "poi")
@XmlRootElement
public class Poi implements Serializable {
    private String id;
    private String value;
    private String category;
}
