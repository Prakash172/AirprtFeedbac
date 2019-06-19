package com.krishna.restroomfeedback.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.krishna.restroomfeedback.R;

public class SubGridAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] mThumbIds;
    public Integer[][] selections;
    public boolean flag;
    private byte rowPosition = -1;


    // Constructor
    public SubGridAdapter(Context c, Integer[] mThumbIds, Integer[][] selections, boolean b, byte rowPosition) {
        this.mThumbIds = mThumbIds;
        this.selections = selections;
        flag = b;
        mContext = c;
        this.rowPosition = rowPosition;

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
        } else {
            grid = (View) convertView;
        }
        ImageView imageView = (ImageView) grid.findViewById(R.id.img_thumb);
        ImageView blackTick = (ImageView) grid.findViewById(R.id.black_tick);
        ImageView whiteTick = (ImageView) grid.findViewById(R.id.white_tick);
        blackTick.setVisibility(View.GONE);
        //whiteTick.setVisibility(View.GONE);

            /*imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag) {

                    }

                }
            });*/
        if (flag) {
            {
                if (selections[rowPosition][position] == 1) {
                    whiteTick.setVisibility(View.VISIBLE);
                } else {
                    whiteTick.setVisibility(View.GONE);
                }
            }
            imageView.setImageResource(mThumbIds[position]);
        } else {
            imageView.setImageResource(mThumbIds[position]);
            whiteTick.setVisibility(View.GONE);
        }
        return grid;
    }
}

