package com.example.hackathon;

import java.util.ArrayList;

public class Place {

    private String address;

    //ArrayLists of reviews each will have a rating from 1 to 5 and a description
    private ArrayList<String[]> reviews;

    public Place(String address){
        //reviewsFromFile();
        this.address = address;
    }

    public void addReview(User user, String message, int rating){
        String[] review = {user.getUsername(), message, String.valueOf(rating)};
        reviews.add(review);
    }

    public ArrayList<String[]> getReviews(){
        return reviews;
    }

}
