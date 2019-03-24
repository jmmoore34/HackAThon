package com.example.hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlaceManager {

    private static ArrayList<Place> places;

    public PlaceManager(){
        places = new ArrayList<>();
        placesFromFile();
    }

    public static void addPlace(Place place){
        places.add(place);
        placesToFile();
    }

    public static Place getPlaceByAddress(String address){
        for(Place plc: places){
            if(plc.getAddress().equalsIgnoreCase(address)){
                return plc;
            }
        }
        return null;
    }
    /**
     * Reads users from a file and adds them to userAccounts list.
     * Format of: username, password
     */
    public static void placesToFile() {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("./places.txt"));
            for (Place place: places){
                String temp = "";
                for(String cat : place.getCategories()){
                    temp = temp + cat + ",";
                }
                file.write(place.getAddress() + "," + temp);
                file.newLine();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads in the list of user accounts from a file.
     * Format of: email, password
     */
    public static void placesFromFile() {
        places = new ArrayList<>();
        if (new File("./places.txt").exists()) {
            try {
                String line;
                BufferedReader file = new BufferedReader(new FileReader("./places.txt"));
                while ((line = file.readLine()) != null) {
                    String[] info = line.split(",");
                    ArrayList<String> temp = new ArrayList<>();
                    for(int i = 1; i < info.length; i++){
                        temp.add(info[i]);
                    }
                    places.add(new Place(info[0], temp));
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Place> getCatagory(String category){
        ArrayList<Place> temp = new ArrayList<>();
        for(Place plc : places){
            if(plc.hasCategory(category)){
                temp.add(plc);
            }
        }
        return temp;
    }
}
