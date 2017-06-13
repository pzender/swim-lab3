package com.example.zender.swim_lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by pzend on 13.06.2017.
 */

public class ActorListFragment extends Fragment {
    public static ActorListFragment newInstance() {
        final ActorListFragment fragment = new ActorListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_actor_list, container, false);
        final Activity activity = getActivity();

        return view;
    }
}
