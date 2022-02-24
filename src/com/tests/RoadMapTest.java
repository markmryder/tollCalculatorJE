package com.tests;

import com.company.LocationService;
import com.company.RoadMap;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoadMapTest {

    private RoadMap map;

    @Before
    public void Setup() {
        LocationService service = new LocationService();
        service.LoadLocations("interchanges.json");
        map = new RoadMap(service.wrapper.locations);
    }

    @Test
    public void GetDistanceEastboundTest() {
        map.GetDistance("QEW", "Brock Road");
        Assert.assertEquals(107.964, map.Distance);
    }
    @Test
    public void GetDistanceWestboundTest() {
        map.GetDistance("Brock Road", "QEW");
        Assert.assertEquals(107.964, map.Distance);
    }

}
