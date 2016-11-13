package com.mowitnow.boot.rest.domain.model;

import java.util.List;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class Track {

    private Point max;

    private List<Point> borders;

    public Track(Point max) {
        this.max = max;
    }

    public Track(Point max, List<Point> borders) {
        this.max = max;
        this.borders = borders;
    }

    public Point getMax() {
        return max;
    }

    public void setMax(Point max) {
        this.max = max;
    }

    public List<Point> getBorders() {
        return borders;
    }

    public void setBorders(List<Point> borders) {
        this.borders = borders;
    }
}

