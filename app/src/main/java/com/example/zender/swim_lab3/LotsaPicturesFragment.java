package com.example.zender.swim_lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pzend on 13.06.2017.
 */

public class LotsaPicturesFragment extends Fragment {
    private static final String ARGUMENT_POSITION = "chosenMoviePosition";
    int chosenMoviePosition;
    Movie chosenMovie;
    public static LotsaPicturesFragment newInstance(int chosenMoviePosition) {
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, chosenMoviePosition);
        final LotsaPicturesFragment fragment = new LotsaPicturesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_lotsa_pictures, container, false);
        final Activity activity = getActivity();
        final ActorListFragment actorListFragment = ActorListFragment.newInstance(chosenMoviePosition);
        final PictureGridFragment pictureGridFragment = PictureGridFragment.newInstance(chosenMoviePosition);
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.add_top, pictureGridFragment, "pictureGrid")
                .add(R.id.add_bot, actorListFragment, "actorList")
                .commit();
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chosenMoviePosition = getArguments().getInt(ARGUMENT_POSITION);
        chosenMovie = MainActivity.movieList.get(chosenMoviePosition);
    }

}
