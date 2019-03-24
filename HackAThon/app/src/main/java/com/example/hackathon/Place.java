package com.example.hackathon;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

public class Place {

    private LatLng address;
   // private ArrayList<Integer> rateList;
    private ArrayList<String> categories;
    //private double rating;
    private String name;

    public Place(LatLng address, ArrayList<String> categories, String name){
        //reviewsFromFile();
        this.address = address;
       // this.rateList = rateList;
        //this.rating = getRating();
        this.categories = categories;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LatLng getAddress() {
        return address;
    }


    public ArrayList<String> getCategories() {
        return categories;
    }

    public boolean hasCategory(String cat){
        for(String st : categories){
            if(st.equals(cat)){
                return true;
            }
        }
        return false;
    }
}
