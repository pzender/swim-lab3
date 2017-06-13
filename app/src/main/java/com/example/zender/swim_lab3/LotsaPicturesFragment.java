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
    public static LotsaPicturesFragment newInstance() {
        final LotsaPicturesFragment fragment = new LotsaPicturesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_lotsa_pictures, container, false);
        final Activity activity = getActivity();
        final ActorListFragment actorListFragment = ActorListFragment.newInstance();
        final PictureGridFragment pictureGridFragment = PictureGridFragment.newInstance();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.add_top, pictureGridFragment, "pictureGrid")
                .add(R.id.add_bot, actorListFragment, "actorList")
                .commit();
        return view;
    }
}
