package com.example.hackathon;

public class Review {

    private String place;
    private String message;
    private int rating;
    private String username;

    public Review(String place, String message, int rating, String username){
        this.place = place;
        this.message = message;
        this.rating = rating;
        this.username = username;
    }
}
