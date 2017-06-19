package com.example.zender.swim_lab3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Movie> movieList = new ArrayList<>();
    public static List<Actor> actorList = new ArrayList<>();
    public static List<Integer> allThumbnails = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        moviesAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(moviesAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchDetails(position);
            }
            @Override
            public void onLongClick(View view, int position) {
                Movie movie = movieList.get(position);
                movie.setWatched(!movie.getWatched());
                ImageView eye = (ImageView)view.findViewById(R.id.eye);
                eye.setImageResource(movie.getWatched() ? R.drawable.eye_full : R.drawable.eye_empty);
            }
        }));
        setupSwipe();
        prepActorData();
        prepThumbnails();
        prepMovieData();
    }

    private void setupSwipe(){
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPos = viewHolder.getAdapterPosition();
                movieList.remove(swipedPos);
                moviesAdapter.notifyDataSetChanged();

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void launchDetails(int positionOfChosenMovie){
        Intent detailsIntent = new Intent(this, MovieDetailsActivity.class);
        detailsIntent.putExtra("position", positionOfChosenMovie);
        startActivityForResult(detailsIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0){
            if (resultCode == RESULT_OK){
                float rating = data.getFloatExtra("rating", 0);
                String recent = data.getStringExtra("title");
                for (int i = 0 ; i > movieList.size() ; i++){
                    Movie look = movieList.get(i);
                    if (look.getTitle().equals(recent))
                        look.setRating(rating);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void prepMovieData(){
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.madmax, R.drawable.madmax_t);
        movieList.add(movie);

        movie = new Movie ("Star Wars: Episode VII - The Force Awakens", "Action", "2015", R.drawable.forceawakens, R.drawable.forceawakens_t);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015", R.drawable.martian, R.drawable.martian_t);
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009", R.drawable.up, R.drawable.up_t);
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009", R.drawable.startrek, R.drawable.startrek_t);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008", R.drawable.ironman, R.drawable.ironman_t);
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986", R.drawable.aliens, R.drawable.aliens_t);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985", R.drawable.backtothefuture, R.drawable.backtothefuture_t);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", R.drawable.raiders, R.drawable.raiders_t);
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965", R.drawable.goldfinger, R.drawable.goldfinger_t);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", R.drawable.guardians, R.drawable.guardians_t);
        movieList.add(movie);

        movie = new Movie("V for Vendetta", "Action, Drama", "2005", R.drawable.v, R.drawable.v_t);
        movieList.add(movie);

        movie = new Movie("Equilibrium", "Action, Drama, Sci-Fi", "2002", R.drawable.equilibrium, R.drawable.equilibrium_t);
        movieList.add(movie);

        movie = new Movie("Warcraft", "Action, Adventure, Fantasy", "2016", R.drawable.warcraft, R.drawable.warcraft_t);
        movieList.add(movie);

        movie = new Movie("The Road", "Adventure, Drama", "2009", R.drawable.road, R.drawable.road_t);
        movieList.add(movie);

        movie = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure, Fantasy", "2001", R.drawable.fellowship, R.drawable.fellowship_t);
        movieList.add(movie);

        moviesAdapter.notifyDataSetChanged();
    }
    private void prepActorData(){
        Actor act = new Actor("Scarlett Johansson", R.drawable.scarjo);
        actorList.add(act);
        act = new Actor("Robert Downey Jr.", R.drawable.downey);
        actorList.add(act);
        act = new Actor("Hugo Weaving", R.drawable.weaving);
        actorList.add(act);
        act = new Actor("Sean Bean", R.drawable.seanbean);
        actorList.add(act);
        act = new Actor("Natalie Portman", R.drawable.portman);
        actorList.add(act);
        act = new Actor("Viggo Mortensen", R.drawable.viggo);
        actorList.add(act);
    }

    private void prepThumbnails(){
        allThumbnails.add(R.drawable.forceawakens_t);
        allThumbnails.add(R.drawable.guardians_t);
        allThumbnails.add(R.drawable.ironman_t);
        allThumbnails.add(R.drawable.raiders_t);
        allThumbnails.add(R.drawable.madmax_t);
        allThumbnails.add(R.drawable.martian_t);
        allThumbnails.add(R.drawable.v_t);
        allThumbnails.add(R.drawable.equilibrium_t);
        allThumbnails.add(R.drawable.fellowship_t);
        allThumbnails.add(R.drawable.warcraft_t);

    }

}
