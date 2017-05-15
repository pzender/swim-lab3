package com.example.zender.swim_lab3;

/**
 * Created by Przemek on 2017-04-24.
 */

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static android.view.View.LAYOUT_DIRECTION_LTR;
import static android.view.View.LAYOUT_DIRECTION_RTL;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import static android.widget.RelativeLayout.ALIGN_RIGHT;
import static android.widget.RelativeLayout.TRUE;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> moviesList;
    private final int LEFT = 0, RIGHT = 1;

    public abstract class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, year, genre;
        public ImageView poster;
        public MyViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            genre = (TextView)view.findViewById(R.id.genre);
            year = (TextView)view.findViewById(R.id.year);
            poster = (ImageView)view.findViewById(R.id.screen);
        }
    }

    public class MyViewHolderLTR extends MyViewHolder{
        public MyViewHolderLTR(View view){
            super(view);
        }
    }

    public class MyViewHolderRTL extends MyViewHolder{
        public TextView title, year, genre;
        public ImageView poster;
        public MyViewHolderRTL(View view){
            super(view);
        }
    }

    public int getItemViewType(int position){
        return position%2;
    }

    public MoviesAdapter(List<Movie> moviesList){
        this.moviesList = moviesList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == LEFT){
            View vLeft = inflater.inflate(R.layout.movie_list_row, parent, false);
            viewHolder = new MyViewHolderLTR(vLeft);
        }
        else {
            View vRight = inflater.inflate(R.layout.movie_list_row_rev, parent, false);
            viewHolder = new MyViewHolderRTL(vRight);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){ //PASKUDNE! Zrób coś z tym bo wiocha
        MyViewHolder temp = (MyViewHolder) holder;
        Movie movie = moviesList.get(position);
        temp.title.setText(movie.getTitle());
        temp.genre.setText(movie.getGenre());
        temp.year.setText(movie.getYear());
        temp.poster.setImageResource(movie.getPosterID());
        if (holder.getItemViewType() == LEFT){
            MyViewHolderLTR vhLeft = (MyViewHolderLTR) temp;

        }
        else if (holder.getItemViewType() == RIGHT){
            MyViewHolderRTL vhRight = (MyViewHolderRTL) temp;
        }
    }
    @Override
    public int getItemCount(){
        return moviesList.size();
    }

}



