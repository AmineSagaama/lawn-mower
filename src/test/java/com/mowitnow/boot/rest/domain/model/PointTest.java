package com.mowitnow.boot.rest.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class PointTest {

    private Point point;
    private final int x = 3;
    private final int y = 3;

    @Before
    public void setUp() {
        point = new Point(x, y);
    }

    @Test
    public void whenInstantiatedThenXIsSet() {
        assertThat(point.getX()).isEqualTo(x);
    }

    @Test
    public void whenInstantiatedThenYIsSet() {
        assertThat(point.getY()).isEqualTo(y);
    }


}

