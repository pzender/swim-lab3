package com.example.zender.swim_lab3;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Przemek on 2017-04-24.
 */

public class Movie implements Serializable{

    private String title, genre, year;
    private boolean watched;
    private float rating;
    private int posterID;
    private int screenID;

    public Movie(String title, String genre, String year, int screenID, int posterID){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.posterID = posterID;
        this.screenID = screenID;
        rating = 0;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPosterID() {
        return posterID;
    }

    public int getScreenID() { return screenID; }

    public void setScreenID(int screenID) { this.screenID = screenID; }

    public boolean getWatched() { return watched; }
}
