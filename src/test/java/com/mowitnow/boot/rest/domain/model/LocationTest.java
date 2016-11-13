package com.mowitnow.boot.rest.domain.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class LocationTest {

    private final int x = 4;
    private final int y = 3;
    private Point max;
    private Location location;
    private final Direction direction = Direction.NORTH;
    private List<Point> borders;

    @Before
    public void setup() {
        max = new Point(5, 5);
        location = new Location(new Point(x, y), direction);
        borders = new ArrayList<Point>();
        borders.add(new Point(0, 5));
        borders.add(new Point(5, 0));
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertThat(location.getX()).isEqualTo(x);
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertThat(location.getY()).isEqualTo(y);
    }

    @Test
    public void whenInstantiatedThenDirectionIsStored() {
        assertThat(location.getDirection()).isEqualTo(direction);
    }

    @Test
    public void givenDirectionNWhenForwardThenYIncreases() {
        location.forward(max, borders);
        assertThat(location.getY()).isEqualTo(y + 1);
    }

    @Test
    public void givenDirectionEWhenForwardThenXIncreases() {
        location.setDirection(Direction.EAST);
        location.forward(max, borders);
        assertThat(location.getX()).isEqualTo(x + 1);
    }

    @Test
    public void givenDirectionWWhenForwardThenXDecreases() {
        location.setDirection(Direction.WEST);
        location.forward(max, borders);
        assertThat(location.getX()).isEqualTo(x - 1);
    }

    @Test
    public void givenDirectionSWhenForwardThenYDecreases() {
        location.setDirection(Direction.SOUTH);
        location.forward(max, borders);
        assertThat(location.getY()).isEqualTo(y - 1);
    }

    @Test
    public void whenTurnLeftThenDirectionIsSet() {
        location.turnLeft();
        assertThat(location.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void whenTurnRightThenDirectionIsSet() {
        location.turnRight();
        assertThat(location.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void givenDirectionNAndXEqualsMaxXWhenForwardThenMaxX() {
        location.getPoint().setX(max.getX());
        location.forward(max, borders);
        assertThat(location.getX()).isEqualTo(max.getX());
    }

    @Test
    public void givenDirectoryNAndYEqualsMaxYWhenForwardThenXInvariable() {
        location.getPoint().setY(max.getY());
        location.forward(max, borders);
        assertThat(location.getX(), is(4));
    }

    @Test
    public void givenDirectoryNAndYEqualsMaxYWhenForwardThenMaxY() {
        location.getPoint().setY(max.getY());
        location.forward(max, borders);
        assertThat(location.getY(), is(max.getY()));
    }

    @Test
    public void givenDirectoryEAndXEqualsMaxXWhenForwardThenYInvariable() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(max.getX());
        location.forward(max, borders);
        assertThat(location.getY(), is(3));
    }
}

