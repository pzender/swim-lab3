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
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
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
                Movie movie = movieList.get(position);
                launchDetails(movie);
            }
            @Override
            public void onLongClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle()+" is long-clicked!", Toast.LENGTH_SHORT).show();
                movie.setWatched(!movie.getWatched());
                ImageView eye = (ImageView)view.findViewById(R.id.eye);
                eye.setImageResource(movie.getWatched() ? R.drawable.eye_full : R.drawable.eye_empty);
            }
        }));
        setupSwipe();
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
                Toast.makeText(getApplicationContext(), movieList.get(swipedPos).getTitle()+" is swiped!", Toast.LENGTH_SHORT).show();
                movieList.remove(swipedPos);
                moviesAdapter.notifyDataSetChanged();

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void launchDetails(Movie chosenMovie){
        Intent detailsIntent = new Intent(this, MovieDetailsActivity.class);
        detailsIntent.putExtra("Movie", chosenMovie);
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
                    if (look.getTitle() == recent)
                        look.setRating(rating);
                }
                Toast.makeText(getApplicationContext(), "Details returned with rating "+rating, Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void prepMovieData(){
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.madmax, R.drawable.madmax_t);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.insideout, R.drawable.insideout_t);
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", R.drawable.forceawakens, R.drawable.forceawakens_t);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015", R.drawable.shaunthesheep, R.drawable.shaunthesheep_t);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015", R.drawable.martian, R.drawable.martian_t);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible - Rogue Nation", "Action", "2015", R.drawable.roguenation, R.drawable.roguenation_t);
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009", R.drawable.up, R.drawable.up_t);
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009", R.drawable.startrek, R.drawable.startrek_t);
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014", R.drawable.legomovie, R.drawable.legomovie_t);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008", R.drawable.ironman, R.drawable.ironman_t);
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986", R.drawable.aliens, R.drawable.aliens_t);
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000", R.drawable.chickenrun, R.drawable.chickenrun_t);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985", R.drawable.backtothefuture, R.drawable.backtothefuture_t);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", R.drawable.raiders, R.drawable.raiders_t);
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965", R.drawable.goldfinger, R.drawable.goldfinger_t);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", R.drawable.guardians, R.drawable.guardians_t);
        movieList.add(movie);

        moviesAdapter.notifyDataSetChanged();
    }
}
