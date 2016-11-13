package com.mowitnow.boot.rest.domain.model;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class Point {

    /**
     * point position in the x-axis
     */
    private int x;

    /**
     * point position in the y-axis
     */
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

