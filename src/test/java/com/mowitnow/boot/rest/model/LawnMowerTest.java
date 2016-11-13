package com.mowitnow.boot.rest.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class LawnMowerTest {

    private Location location;
    private Track track;
    private LawnMower lawnMower;

    @Before
    public void setup() {
        Point max = new Point(5, 5);
        location = new Location(new Point(5, 5), Direction.NORTH);
        List<Point> borders = new ArrayList<Point>();
        borders.add(max);
        borders.add(new Point(0, 5));
        borders.add(new Point(5, 0));
        track = new Track(max, borders);
        lawnMower = new LawnMower(location, track);
    }

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        assertThat(lawnMower.getLocation()).isEqualTo(location);
    }

    @Test
    public void whenInstantiatedThenTrackIsSet() {
        assertThat(lawnMower.getTrack()).isEqualTo(track);
    }
}

