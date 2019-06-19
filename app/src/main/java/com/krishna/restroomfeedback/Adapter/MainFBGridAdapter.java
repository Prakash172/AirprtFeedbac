package com.krishna.restroomfeedback.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.krishna.restroomfeedback.R;

import java.util.Objects;

public class MainFBGridAdapter extends BaseAdapter {
    private Context mContext;
    private int[] mThumbIds;
    private String[] mThumbTtitles;


    // Constructor
    public MainFBGridAdapter(Context c, String[] mThumbTtitles, int[] mThumbIds) {
        mContext = c;
        this.mThumbIds = mThumbIds;
        this.mThumbTtitles = mThumbTtitles;
    }


    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = Objects.requireNonNull(inflater).inflate(R.layout.item_main_fb, null);
        } else

        {
            grid = convertView;
        }

        ImageView imageView = grid.findViewById(R.id.grid_img);
        TextView textView = grid.findViewById(R.id.grid_txt);

        imageView.setImageResource(mThumbIds[position]);
        textView.setText(mThumbTtitles[position]);


        return grid;
    }
}

