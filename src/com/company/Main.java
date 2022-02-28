package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String start, stop;
        Scanner input = new Scanner(System.in);
        if(args.length < 2) {
            System.out.println("Enter staring point: ");
            start = input.nextLine();
            System.out.println("Enter end point: ");
            stop = input.nextLine();
        } else {
            start = args[0];
            stop = args[1];
        }

        try {
             Trip trip = new Trip(start, stop);
             trip.calculateTrip();
             System.out.println(String.format("Total cost: $%s",trip.TotalCost));
             System.out.println(String.format("Total distance: %s Km", trip.Distance));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
}
