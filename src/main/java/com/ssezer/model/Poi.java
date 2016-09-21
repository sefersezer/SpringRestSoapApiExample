package com.ssezer.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Document(collection = "poi")
public class Poi{
    private String id;
    private String value;
    private String category;
}
