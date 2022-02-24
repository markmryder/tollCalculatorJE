package com.tests;

import com.company.LocationService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocationServiceTest {
    public LocationService service;

    @Before
    public void Setup() {
        service = new LocationService();
        service.LoadLocations("interchanges.json");
    }


    @Test
    public void LoadLocationsTest() {
        int count = service.locations.locations.size();
        Assert.assertEquals(44,count);
    }

    @Test
    public void LoadLocationsFromFileFails() {
        service = new LocationService();
        service.LoadLocations("Bad file path");
        Assert.assertNull(service.locations);
    }

    @Test
    public void ValidateStartEndBadStart() {
        boolean isValid = service.ValidateStartEnd("QEWWW", "Brock Road");
        Assert.assertFalse(isValid);
    }
    @Test
    public void ValidateStartEndBadEnd() {
        boolean isValid = service.ValidateStartEnd("QEW", "Brock");
        Assert.assertFalse(isValid);
    }
    @Test
    public void ValidateStartGoodData() {
        boolean isValid = service.ValidateStartEnd("QEW", "Brock Road");
        Assert.assertTrue(isValid);
    }
}
