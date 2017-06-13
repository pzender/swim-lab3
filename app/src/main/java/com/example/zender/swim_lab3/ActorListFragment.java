package com.example.zender.swim_lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by pzend on 13.06.2017.
 */

public class ActorListFragment extends Fragment {
    private static final String ARGUMENT_POSITION = "chosenMoviePosition";
    int chosenMoviePosition;
    Movie chosenMovie;
    public static ActorListFragment newInstance(int chosenMoviePosition) {
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, chosenMoviePosition);
        final ActorListFragment fragment = new ActorListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_actor_list, container, false);
        final Activity activity = getActivity();
        ListView list = (ListView) view.findViewById(R.id.list_view);
        //list.setAdapter(new SimpleAdapter());
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chosenMoviePosition = getArguments().getInt(ARGUMENT_POSITION);
        chosenMovie = MainActivity.movieList.get(chosenMoviePosition);
    }

}
