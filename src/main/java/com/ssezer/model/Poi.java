package com.ssezer.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "poi")
public class Poi{
    private String id;
    private String value;
    private String category;
}
