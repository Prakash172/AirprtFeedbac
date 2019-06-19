package com.krishna.restroomfeedback.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.krishna.restroomfeedback.R;

public class MainGridAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] mThumbIds;
    public Integer[][] selections;
    public Boolean[] selected;
    public boolean flag;
    private byte rowPosition = -1;


    // Constructor
    public MainGridAdapter(Context c, Integer[] mThumbIds, Boolean[] selected) {
        this.mThumbIds = mThumbIds;
        this.selected = selected;
        mContext = c;
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
            grid = inflater.inflate(R.layout.fb_main_layout, null);
        } else

        {
            grid = (View) convertView;
        }
        ImageView imageView = (ImageView) grid.findViewById(R.id.img_thumb);
        ImageView blackTick = (ImageView) grid.findViewById(R.id.black_tick);
        ImageView whiteTick = (ImageView) grid.findViewById(R.id.white_tick);
        blackTick.setVisibility(View.GONE);
        whiteTick.setVisibility(View.GONE);
        imageView.setImageResource(mThumbIds[position]);

        Log.i("Selected: "+position," "+selected[position]);
        if (selected[position] == true) {
            blackTick.setVisibility(View.VISIBLE);
        } else
            blackTick.setVisibility(View.GONE);

//        for (int i = 0; i < 4; i++)
//            for (int j = 0; j < 2; j++) {
//                if (selections[i][j] == 1) {
//                    if (position == i)
//                        blackTick.setVisibility(View.VISIBLE);
//                    else
//                        blackTick.setVisibility(View.GONE);
//                } else {
//                    //blackTick.setVisibility(View.GONE);
//                }
//            }

        return grid;
    }
}

