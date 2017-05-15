package com.example.zender.swim_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetailsActivity extends AppCompatActivity {
    Movie chosenMovie;
    RatingBar ratingBar;

/*
    private View.OnClickListener ratingBarListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            ratingBar.getNumStars();
        }
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        chosenMovie = (Movie)getIntent().getSerializableExtra("Movie");
        ImageView screen = (ImageView)findViewById(R.id.imageView);
        screen.setImageResource(chosenMovie.getScreenID());


        TextView title = (TextView)findViewById(R.id.title);
        title.setText(chosenMovie.getTitle());
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                chosenMovie.setRating(rating);
                Toast.makeText(getApplicationContext(), "Rating changed to "+rating, Toast.LENGTH_SHORT).show();
            }
        });
        ratingBar.setRating(chosenMovie.getRating());
        Toast.makeText(getApplicationContext(), "Current rating: "+chosenMovie.getRating(), Toast.LENGTH_SHORT).show();
        //TextView
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent();
        back.putExtra("rating", chosenMovie.getRating());
        back.putExtra("title", chosenMovie.getTitle());
        setResult(RESULT_OK, back);
        super.onBackPressed();
    }

}
