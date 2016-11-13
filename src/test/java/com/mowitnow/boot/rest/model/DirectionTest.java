package com.mowitnow.boot.rest.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class DirectionTest {

    @Test
    public void whenGetFromShortNameNThenReturnDirectionN() {
        Direction direction = Direction.getFromShortName('N');
        assertThat(direction).isEqualTo(Direction.NORTH);
    }

    @Test
    public void whenGetFromShortNameWThenReturnDirectionW() {
        Direction direction = Direction.getFromShortName('W');
        assertThat(direction).isEqualTo(Direction.WEST);
    }

    @Test
    public void whenGetFromShortNameEThenReturnDirectionE() {
        Direction direction = Direction.getFromShortName('E');
        assertThat(direction).isEqualTo(Direction.EAST);
    }

    @Test
    public void whenGetFromShortNameSThenReturnDirectionS() {
        Direction direction = Direction.getFromShortName('S');
        assertThat(direction).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void whenGetFromShortNameXThenReturnDirectionNone() {
        Direction direction = Direction.getFromShortName('X');
        assertThat(direction).isEqualTo(Direction.NONE);
    }

    @Test
    public void givenNWhenLeftThenW() {
        assertThat(Direction.NORTH.turnLeft()).isEqualTo(Direction.WEST);
    }

    @Test
    public void givenWWhenRightThenN() {
        assertThat(Direction.WEST.turnRight()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void givenNWhenRightThenE() {
        assertThat(Direction.NORTH.turnRight()).isEqualTo(Direction.EAST);
    }

    @Test
    public void givenSWhenLeftThenE() {
        assertThat(Direction.SOUTH.turnLeft()).isEqualTo(Direction.EAST);
    }

    @Test
    public void givenEWhenLeftThenN() {
        assertThat(Direction.EAST.turnLeft()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void givenWWhenLeftThenS() {
        assertThat(Direction.WEST.turnLeft()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void givenSWhenRightThenW() {
        assertThat(Direction.SOUTH.turnRight()).isEqualTo(Direction.WEST);
    }

    @Test
    public void givenEWhenRightThenS() {
        assertThat(Direction.EAST.turnRight()).isEqualTo(Direction.SOUTH);
    }

}

