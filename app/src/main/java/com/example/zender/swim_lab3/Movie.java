package com.example.zender.swim_lab3;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Przemek on 2017-04-24.
 */

public class Movie implements Serializable{

    private String title, genre, year;
    private boolean watched;
    private int rating;
    private int posterID;

    public Movie(String title, String genre, String year, int posterID){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.posterID = posterID;
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

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPosterID() {
        return posterID;
    }
}
