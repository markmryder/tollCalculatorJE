package com.company;
import com.google.gson.annotations.SerializedName;
import java.util.*;

public class LocationsWrapper {

    @SerializedName("locations")
    public LinkedHashMap<String, Location> locations;

}
