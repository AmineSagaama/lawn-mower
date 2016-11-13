package com.mowitnow.boot.rest.domain.repository;

import java.util.Collection;

/**
 * Created by asagaama on 13/11/2016.
 */
public interface MowerRepository {

    /**
     * @param payload
     * @return
     * @throws Exception
     */
    public Collection<String> process(String payload) throws Exception;
}
