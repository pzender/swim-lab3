package com.example.zender.swim_lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by pzend on 13.06.2017.
 */

public class PictureGridFragment extends Fragment {
    private static final String ARGUMENT_POSITION = "chosenMoviePosition";
    int chosenMoviePosition;
    Movie chosenMovie;
    private GridView grid;
    public static PictureGridFragment newInstance(int chosenMoviePosition){
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, chosenMoviePosition);
        final PictureGridFragment fragment = new PictureGridFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_picture_grid, container, false);
        grid = (GridView)view.findViewById(R.id.grid_view);
        grid.setAdapter(new PicAdapter(this.getContext(), (ArrayList)chosenMovie.getPictureIDs()));
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chosenMoviePosition = getArguments().getInt(ARGUMENT_POSITION);
        chosenMovie = MainActivity.movieList.get(chosenMoviePosition);
    }

}
