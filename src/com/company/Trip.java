package com.company;

public class Trip {

    public String Start;
    public String End;
    private LocationService service;
    private double rate  = 0.25;
    public double TotalCost;
    public RoadMap map;
    public double Distance;

    public Trip(String start, String end) throws Exception {
        service = new LocationService();
        //Normally load from resources or some external path
        service.LoadLocations("interchanges.json");
        if(service.ValidateStartEnd(start, end)) {
            this.Start = start;
            this.End = end;

            map = new RoadMap(service.locations.locations);
            map.GetDistance(Start, End);
        }
        else {
            throw new Exception("Invalid start or end entered");
        }
    }

    public void calculateTrip() {
        TotalCost = (double) Math.round(map.Distance * rate * 100d) / 100d;
        Distance = (double) Math.round(map.Distance * 100d) / 100d;
    }

}
