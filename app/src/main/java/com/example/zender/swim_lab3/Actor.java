package com.example.zender.swim_lab3;

/**
 * Created by pzend on 13.06.2017.
 */

public class Actor {
    Actor(String name, int picID){
        this.name = name;
        this.picID = picID;
    }
    private String name;
    private int picID;


    public String getName() {
        return name;
    }

    public int getPicID() {
        return picID;
    }
}
