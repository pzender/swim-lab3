package com.example.zender.swim_lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {
    Movie chosenMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        chosenMovie = (Movie)getIntent().getSerializableExtra("Movie");
        ImageView screen = (ImageView)findViewById(R.id.imageView);
        screen.setImageResource(chosenMovie.getPosterID());

        TextView title = (TextView)findViewById(R.id.title);
        title.setText(chosenMovie.getTitle());

        //TextView
    }


}
