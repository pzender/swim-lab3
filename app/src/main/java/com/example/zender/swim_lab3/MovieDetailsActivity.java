package com.example.zender.swim_lab3;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetailsActivity extends AppCompatActivity
    implements MovieDetailsFragment.OnPictureClicked {
    int chosenMoviePosition;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chosenMoviePosition = getIntent().getIntExtra("position", 0);
        Configuration config = getResources().getConfiguration();

        //android.app.FragmentManager fragmentManager = getFragmentManager();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.det_frag, MovieDetailsFragment.newInstance(chosenMoviePosition))
                    .commit();
        }
        setContentView(R.layout.activity_movie_details);
    }

    @Override
    public void onPictureClicked() {
        Toast.makeText(this, "Picture clicked!", Toast.LENGTH_SHORT).show();
        final LotsaPicturesFragment lotsaPicturesFragment = LotsaPicturesFragment.newInstance(chosenMoviePosition);
        //getSupportFragmentManager().
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.det_frag, lotsaPicturesFragment)
                .addToBackStack(null)
                .commit();
    }
}
