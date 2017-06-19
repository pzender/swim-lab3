package com.example.zender.swim_lab3;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Przemek on 2017-06-13.
 */

public class ActorAdapter extends BaseAdapter {
    private Activity activity;
    private static LayoutInflater inflater = null;
    private ArrayList data;
    Actor tempVals = null;
    public ActorAdapter(Activity act, ArrayList d){
        activity = act;
        data = d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public static class ActorViewHolder{
        public TextView name;
        public ImageView pic;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        ActorViewHolder holder;
        if (convertView == null){
            view = inflater.inflate(R.layout.actor_list_row, null);
            holder = new ActorViewHolder();
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.pic = (ImageView) view.findViewById(R.id.pic);
            view.setTag(holder);
        }
        else
            holder = (ActorViewHolder)view.getTag();
        if (data.size() <= 0)
            holder.name.setText("Nothing here!");
        else {
            tempVals = null;
            tempVals = (Actor) data.get(position);
            holder.name.setText(tempVals.getName());
            holder.pic.setImageResource(tempVals.getPicID());
        }
        return view;
    }

    @Override
    public int getCount() {
        return data.size()<=0 ? 1 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
