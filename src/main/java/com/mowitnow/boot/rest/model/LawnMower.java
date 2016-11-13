package com.mowitnow.boot.rest.model;

/**
 * Created by Amine Sagaama on 13/11/2016.
 */
public class LawnMower {

    private Location location;

    private Track track;

    public LawnMower(Location location, Track track) {
        this.location = location;
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    public Location getLocation() {
        return location;
    }

    public boolean moveForward() {
        return location.forward(track.getMax(), track.getBorders());
    }

    public void turnRight() {
        location.turnRight();
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public String executeCommands(String commands) {
        StringBuilder output = new StringBuilder();
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'A':
                    moveForward();
                    break;
                case 'D':
                    turnRight();
                    break;
                case 'G':
                    turnLeft();
                    break;
            }
        }
        return output.toString();
    }
}

