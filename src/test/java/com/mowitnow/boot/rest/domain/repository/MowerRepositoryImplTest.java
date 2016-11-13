package com.mowitnow.boot.rest.domain.repository;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by asagaama on 13/11/2016.
 */
public class MowerRepositoryImplTest {

    private MowerRepositoryImpl mowerRepositoryImpl;

    @Before
    public void setup() {
        mowerRepositoryImpl = new MowerRepositoryImpl();
    }

    @Test
    public void givenPayloadWhenprocessThenLocations() throws Exception {
        String payload = "5 5\n" + "1 2 N\n" + "GAGAGAGAA\n" + "3 3 E\n" + "AADAADADDA";
        mowerRepositoryImpl.process(payload);
    }
}
