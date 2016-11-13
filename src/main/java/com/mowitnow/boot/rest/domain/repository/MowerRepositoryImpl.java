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
        Scanner scanner = new Scanner(payload);
        String maxLine = scanner.nextLine();
        String max = maxLine.replaceAll("\\s+", "");
        Point maxPoint = new Point(Character.getNumericValue(max.charAt(0)), Character.getNumericValue(max.charAt(1)));
        while (scanner.hasNextLine()) {
            String locationLine = scanner.nextLine();
            LawnMower lawnMower = getLawnMowerFromPayload(max, maxPoint, locationLine);
            String commandsLine = scanner.nextLine();
            lawnMower.executeCommands(commandsLine);
            locations.add(lawnMower.getLocation().toString());
        }
        return locations;
    }

    protected Location getPositionFromLine(String line) {
        String spaceLessLine = line.replaceAll("\\s+", "");
        return new Location(new Point(Character.getNumericValue(spaceLessLine.charAt(0)), Character.getNumericValue(spaceLessLine.charAt(1))), Direction.getFromShortName(spaceLessLine.charAt(2)));
    }

    private LawnMower getLawnMowerFromPayload(String max, Point maxPoint, String locationLine) {
        Location location = getPositionFromLine(locationLine);
        List<Point> borders = new ArrayList<Point>();
        borders.add(maxPoint);
        borders.add(new Point(0, max.charAt(1)));
        borders.add(new Point(max.charAt(0), 0));
        Track track = new Track(maxPoint, borders);
        return new LawnMower(location, track);
    }
}
