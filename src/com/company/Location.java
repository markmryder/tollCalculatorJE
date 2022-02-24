package com.company;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Location {

    @SerializedName("name")
    public String Name;
    @SerializedName("lat")
    public double Lat;
    @SerializedName("lng")
    public double Lng;
    @SerializedName("routes")
    public List<Route> Routes;
    @SerializedName("devcomment")
    public String Devcomment;
}
