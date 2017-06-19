package com.example.zender.swim_lab3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by pzend on 19.06.2017.
 */

public class PicAdapter extends BaseAdapter {
    private ArrayList data;
    private Context context;

    PicAdapter(Context c, ArrayList d){
        context = c;
        data = d;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
        }
        else imageView = (ImageView)convertView;

        imageView.setImageResource((int) data.get(position));

        return imageView;
    }
}
