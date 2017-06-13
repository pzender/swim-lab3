package com.example.zender.swim_lab3;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Przemek on 2017-04-24.
 */

public class Movie implements Serializable{

    private String title, genre, year;
    private boolean watched;
    private float rating;
    private int posterID;
    private int screenID;
    private List<Actor> actors = new ArrayList<>();
    private List<Integer> pictureIDs = new ArrayList<>();

    public Movie(String title, String genre, String year, int screenID, int posterID){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.posterID = posterID;
        this.screenID = screenID;
        rating = 0;
        actors = prepActors();
        pictureIDs = prepPicIDs();
    }

    private List<Actor> prepActors(){
        List<Actor> list = new ArrayList<>();
        Actor act = new Actor("Scarlett Johansson", R.drawable.scarjo);
        list.add(act);
        act = new Actor("Robert Downey Jr.", R.drawable.downey);
        list.add(act);
        act = new Actor("Hugo Weaving", R.drawable.weaving);
        return list;
    }

    private List<Integer> prepPicIDs(){
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.forceawakens_t);
        list.add(R.drawable.guardians_t);
        list.add(R.drawable.ironman_t);
        list.add(R.drawable.raiders_t);
        list.add(R.drawable.madmax_t);
        list.add(R.drawable.martian_t);
        return list;
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
