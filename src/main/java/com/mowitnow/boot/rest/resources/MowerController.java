package com.mowitnow.boot.rest.resources;

import com.mowitnow.boot.rest.domain.service.MowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
@RestController
@RequestMapping("/v1/mower")
public class MowerController {

    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(MowerController.class.getName());

    /**
     *
     */
    protected MowerService mowerService;

    /**
     * @param mowerService
     */
    @Autowired
    public MowerController(MowerService mowerService) {
        this.mowerService = mowerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Collection<String>> process(@RequestBody String payload) {
        logger.info(String.format("mower-service process() invoked:{} for {} ", mowerService.getClass().getName(), payload));
        Collection<String> locations;
        try {
            locations = mowerService.process(payload);
        } catch (Exception cause) {
            logger.log(Level.WARNING, "Exception raised add Process REST Call {0}", cause);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return locations.size() > 0 ? new ResponseEntity<>(locations, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
