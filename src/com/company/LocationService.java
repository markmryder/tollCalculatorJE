package com.company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.Scanner;



public class LocationService {

    public LocationsWrapper wrapper;

    public void LoadLocations(String filename) {

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            wrapper = gson.fromJson(data, LocationsWrapper.class);

        } catch(Exception e) {
            System.out.println("Error reading file");
        }
    }

    public boolean ValidateStartEnd(String start, String end) {
        boolean isStartValid = false;
        boolean isEndValid = false;
        for (Location location : wrapper.locations.values()) {
            if (start.equals(location.Name)) {
                isStartValid = true;
            }
            if (end.equals(location.Name)) {
                isEndValid = true;
            }
        }
        return isEndValid && isStartValid;
    }

}
