package com.company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;



public class LocationService {

    public Locations locations;

    public void LoadLocations(String filename) {

        try{
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            locations = gson.fromJson(data,Locations.class);

        }catch(Exception e){
            System.out.println("Error reading file");
            //throw new Exception("Error reading file");
        }
    }

    public boolean ValidateStartEnd(String start, String end) {
        boolean isStartValid = false;
        boolean isEndValid = false;
        for(Location location : locations.locations.values()) {
            if (start.equals(location.Name)) {
                isStartValid = true;
            }
            if (end.equals(location.Name)) {
                isEndValid = true;
            }
        }
        //System.out.println(String.format("Start: %s, Stop: %s",start, end));
        return isEndValid && isStartValid;
    }

}
