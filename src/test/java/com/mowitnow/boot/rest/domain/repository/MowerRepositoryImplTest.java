package com.mowitnow.boot.rest.domain.repository;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by asagaama on 13/11/2016.
 */
public class MowerRepositoryImplTest {

    private MowerRepositoryImpl mowerRepositoryImpl;
    private String payload;

    @Before
    public void setup() {

        mowerRepositoryImpl = new MowerRepositoryImpl();
        payload = "5 5\n" + "1 2 N\n" + "GAGAGAGAA\n" + "3 3 E\n" + "AADAADADDA";
    }

    @Test
    public void givenPayloadWhenProcessThenLocations() throws Exception {
        Collection<String> expectedList = Arrays.asList("1 3 N", "5 1 E");
        Collection<String> resultList = mowerRepositoryImpl.process(payload);
        assertThat(resultList, hasSize(2));
        assertThat(resultList, is(expectedList));
    }
}
