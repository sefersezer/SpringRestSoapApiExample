package com.exastax.model;

import com.exastax.ws.model.PoiEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    ModelMapper modelMapper = new ModelMapper();

    public PoiEntity mapPoi(Poi poiDTO) {
        return modelMapper.map(poiDTO, PoiEntity.class);
    }

    public List<PoiEntity> mapPoiList(List<Poi> poiList) {
        List<PoiEntity> poiEntityList = new ArrayList<>();
        poiList.forEach(poi -> poiEntityList.add(mapPoi(poi)));
        return poiEntityList;
    }

    public Poi mapPoiDTO(PoiEntity poiEntity) {
        return modelMapper.map(poiEntity, Poi.class);
    }
}
