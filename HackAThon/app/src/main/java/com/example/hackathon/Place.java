package com.example.hackathon;

import java.io.Serializable;
import java.util.ArrayList;

public class Place {

    private String address;
   // private ArrayList<Integer> rateList;
    private ArrayList<String> categories;
    //private double rating;

    public Place(String address, ArrayList<String> categories){
        //reviewsFromFile();
        this.address = address;
       // this.rateList = rateList;
        //this.rating = getRating();
        this.categories = categories;
    }

    //public ArrayList<Integer> getRateList() {
   //     return rateList;
   // }

    public String getAddress() {
        return address;
    }

//    public double getRating(){
//        double temp = 0;
//        for(int i = 0; i < rateList.size(); i++){
//            temp += rateList.get(i);
//        }
//        if(rateList.size() != 0){
//            return temp/rateList.size();
//        }
//        return 0;
//    }

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
