package com.mowitnow.boot.rest.domain.service;

import java.util.Collection;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public interface MowerService {

    /**
     * @param payload
     * @return
     * @throws Exception
     */
    public Collection<String> process(String payload) throws Exception;
}
