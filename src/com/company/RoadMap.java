package com.company;

import java.util.*;

public class RoadMap {

    public List<Location> Exits;
    public double Distance;

    public RoadMap(LinkedHashMap<String,Location> locations) {
        Exits = new ArrayList<Location>();
        CreateExits(locations);
    }

    public void GetDistance(String start, String end) {

        var startLocation = Exits.stream().filter(location -> start.equals(location.Name)).findFirst().orElse(null);
        var endLocation = Exits.stream().filter(location -> end.equals(location.Name)).findFirst().orElse(null);
        int startIndex = Exits.indexOf(startLocation);
        int endIndex = Exits.indexOf(endLocation);


        double distance = 0f;
        int routeIndex;

        if (startIndex < endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                distance += Exits.get(i).Routes.get(0).Distance;
            }
        } else {
            for (int i = startIndex; i > endIndex; i--) {
                distance += Exits.get(i).Routes.get(1).Distance;
            }
        }
        Distance = (double) Math.round(distance * 1000d) / 1000d;
    }

    private void CreateExits(LinkedHashMap<String,Location> locations) {
        Exits.clear();
        for(Location location : locations.values()) {
            Exits.add(location);
        }
    }

}
