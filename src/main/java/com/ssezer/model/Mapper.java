package com.ssezer.model;

import com.ssezer.ws.model.PoiEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

  private ModelMapper modelMapper = new ModelMapper();

  public PoiEntity mapPoi(Poi poiDTO) {
    return modelMapper.map(poiDTO, PoiEntity.class);
  }

  public List<PoiEntity> mapPoiList(List<Poi> poiList) {
    return poiList.stream().map(this::mapPoi).collect(Collectors.toList());
  }

  public Poi mapPoiDTO(PoiEntity poiEntity) {
    return modelMapper.map(poiEntity, Poi.class);
  }
}
