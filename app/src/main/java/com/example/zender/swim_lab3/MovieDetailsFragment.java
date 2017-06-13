package com.example.zender.swim_lab3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetailsFragment extends Fragment {
    private Movie chosenMovie;
    private OnPictureClicked mListener;
    int chosenMoviePosition;
    RatingBar ratingBar;
    private static final String ARGUMENT_POSITION = "chosenMoviePosition";

    public static MovieDetailsFragment newInstance(int chosenMoviePosition){
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, chosenMoviePosition);
        final MovieDetailsFragment fragment = new MovieDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        final Activity activity = getActivity();
        final ImageView screen = (ImageView) view.findViewById(R.id.imageView);
        screen.setImageResource(chosenMovie.getScreenID());
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onPictureClicked();
            }
        });

        TextView title = (TextView)view.findViewById(R.id.title);
        title.setText(chosenMovie.getTitle());
        ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                chosenMovie.setRating(rating);
            }
        });
        ratingBar.setRating(chosenMovie.getRating());
        return view;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnPictureClicked)
            mListener = (OnPictureClicked)context;
        else throw new ClassCastException(context.toString() + " doesnt implement OnPictureClicked! ");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chosenMoviePosition = getArguments().getInt(ARGUMENT_POSITION);
        chosenMovie = MainActivity.movieList.get(chosenMoviePosition);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnPictureClicked{
        void onPictureClicked();
    }
}
