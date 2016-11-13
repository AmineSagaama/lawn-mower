package com.mowitnow.boot.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class Location {

    private static final int FORWARD = 1;

    private Point point;
    private Direction direction;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public boolean forward(Point max) {
        return move(FORWARD, max, new ArrayList<Point>());
    }

    public boolean forward(Point max, List<Point> borders) {
        return move(FORWARD, max, borders);
    }

    /**
     * @param point
     * @param borders
     * @return
     */
    private boolean isBorder(Point point, List<Point> borders) {
        for (Point border : borders
                ) {
            if (border.getX() == point.getX() && border.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param fw
     * @param max
     * @param obstacles
     * @return
     */
    private boolean move(int fw, Point max, List<Point> obstacles) {
        int x = point.getX();
        int y = point.getY();
        switch (getDirection()) {
            case NORTH:
                y = wrap(getY() + fw, max.getY());
                break;
            case SOUTH:
                y = wrap(getY() - fw, max.getY());
                break;
            case EAST:
                x = wrap(getX() + fw, max.getX());
                break;
            case WEST:
                x = wrap(getX() - fw, max.getX());
                break;
        }
        if (isBorder(new Point(x, y), obstacles)) {
            return false;
        } else {
            point = new Point(x, y);
            return true;
        }
    }

    /**
     * @param point
     * @param maxPoint
     * @return
     */
    private int wrap(int point, int maxPoint) {
        if (maxPoint >= 0 && point > maxPoint) {
            return maxPoint;
        }
        return point;
    }

    public void turnLeft() {
        this.direction = direction.turnLeft();
    }

    public void turnRight() {
        this.direction = direction.turnRight();
    }
}
