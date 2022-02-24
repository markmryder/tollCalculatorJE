package com.company;

import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("toId")
    public long ToId;
    @SerializedName("distance")
    public double Distance;
    @SerializedName("exit")
    public boolean Exit;
    @SerializedName("enter")
    public boolean Enter;
    @SerializedName("startDate")
    public String StartDate;

}
