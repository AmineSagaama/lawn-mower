package com.mowitnow.boot.rest.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class TrackTest {

    private Track track;
    private Point max = new Point(5, 5);
    private List<Point> borders;

    @Before
    public void setup() {
        borders = new ArrayList<Point>();
        borders.add(new Point(0, 5));
        borders.add(new Point(5, 0));
        track = new Track(max, borders);
    }

    @Test
    public void whenInstantiatedThenMaxIsSet() {
        assertThat(track.getMax()).isEqualTo(max);
    }

    @Test
    public void whenInstantiatedThenBordersAreSet() {
        Assertions.assertThat(track.getBorders()).isEqualTo(borders);
    }
}
