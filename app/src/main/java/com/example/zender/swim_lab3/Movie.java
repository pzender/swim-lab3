package com.example.zender.swim_lab3;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Przemek on 2017-04-24.
 */

public class Movie implements Serializable{

    private String title, genre, year;
    private boolean watched;
    private float rating;
    private int posterID;
    private int screenID;
    private ArrayList<Actor> actors = new ArrayList<>();
    private ArrayList<Integer> pictureIDs = new ArrayList<>();



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

    private ArrayList<Actor> prepActors(){
        Random r = new Random();
        ArrayList<Actor> list = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++)
            list.add(MainActivity.actorList.get(r.nextInt(MainActivity.actorList.size())));
        return list;
    }

    private ArrayList<Integer> prepPicIDs(){
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 6 ; i++)
            list.add(MainActivity.allThumbnails.get(r.nextInt(MainActivity.allThumbnails.size())));
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

    public List<Actor> getActors() {
        return actors;
    }

    public List<Integer> getPictureIDs() {
        return pictureIDs;
    }
}
