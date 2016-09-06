package com.exastax.ws.rest;

import com.exastax.ws.model.PoiEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/entity")
public interface EntityService {

    /**
     * Note:
     * RequestParam : http://localhost/entity?query=1
     * PathVariable : http://localhost/entity/1
     */

    @RequestMapping(value = "/{query}",
            method = RequestMethod.GET,
            produces = "application/json")
    ResponseEntity getEntities(@PathVariable(value = "query") String query, @RequestParam("limit") Optional<Integer> limit);

    @RequestMapping(value = "/{entityId}",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity saveEntity(@PathVariable("entityId") String id, @RequestBody PoiEntity entity);

    // put method have 2 option. first one update, second one create.
    @RequestMapping(value = "/{entityId}",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity updateEntity(@PathVariable("entityId") String id, @RequestBody PoiEntity entity);

    @RequestMapping(value = "/{entityId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity deleteEntity(@PathVariable(value = "entityId") String entityId);
}
