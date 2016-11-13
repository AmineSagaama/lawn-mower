package com.mowitnow.boot.rest.domain.repository;

import com.mowitnow.boot.rest.domain.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Created by asagaama on 13/11/2016.
 */
@Repository("mowerRepository")
public class MowerRepositoryImpl implements MowerRepository {
    /**
     * @param payload
     * @return
     * @throws Exception
     */
    @Override
    public Collection<String> process(String payload) throws Exception {
        Collection<String> locations = new ArrayList<>();
        getLocationsFromPayload(payload, locations);
        return locations;
    }

    /**
     * @param payload
     * @param locations
     */
    private void getLocationsFromPayload(String payload, Collection<String> locations) {
        Scanner scanner = new Scanner(payload);
        String maxLine = scanner.nextLine();
        Point maxPoint = getPositionFromLine(maxLine);
        while (scanner.hasNextLine()) {
            String locationLine = scanner.nextLine();
            LawnMower lawnMower = getLawnMowerFromPayload(maxPoint, maxPoint, locationLine);
            String commandsLine = scanner.nextLine();
            lawnMower.executeCommands(commandsLine);
            locations.add(lawnMower.getLocation().toString());
        }
    }

    /**
     * @param line
     * @return
     */
    protected Point getPositionFromLine(String line) {
        String spaceLessLine = line.replaceAll("\\s+", "");
        return new Point(Character.getNumericValue(spaceLessLine.charAt(0)), Character.getNumericValue(spaceLessLine.charAt(1)));
    }

    /**
     * @param line
     * @return
     */
    protected Location getLocationFromLine(String line) {
        String spaceLessLine = line.replaceAll("\\s+", "");
        return new Location(new Point(Character.getNumericValue(spaceLessLine.charAt(0)), Character.getNumericValue(spaceLessLine.charAt(1))), Direction.getFromShortName(spaceLessLine.charAt(2)));
    }

    /**
     * @param max
     * @param maxPoint
     * @param locationLine
     * @return
     */
    private LawnMower getLawnMowerFromPayload(Point max, Point maxPoint, String locationLine) {
        Location location = getLocationFromLine(locationLine);
        List<Point> borders = new ArrayList<Point>();
        borders.add(maxPoint);
        borders.add(new Point(0, max.getY()));
        borders.add(new Point(max.getX(), 0));
        Track track = new Track(maxPoint, borders);
        return new LawnMower(location, track);
    }
}
