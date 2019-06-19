package com.krishna.restroomfeedback.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.krishna.restroomfeedback.Adapter.MainGridAdapter;
import com.krishna.restroomfeedback.Adapter.SubGridAdapter;
import com.krishna.restroomfeedback.R;

public class MoreFeedBackActivity extends Activity {

    public static final int FLOOR = 0;
    public static final int TOILET = 1;
    public static final int TISSUES = 2;
    public static final int MIRRORS = 3;
    GridView fb_grid, fb_detail_grid;
    MainGridAdapter mainGridAdapter;
    SubGridAdapter subGridAdapter;
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.mipmap.floor_img, R.mipmap.toilet_img, R.mipmap.tissues_img, R.mipmap.mirrors_img
    };
    public Integer[] q1 = {R.mipmap.partially_wet, R.mipmap.wet_img};
    public Integer[] q2 = {R.mipmap.smelly, R.mipmap.unclean};
    public Integer[] q3 = {R.mipmap.insufficient, R.mipmap.not_available};
    public Integer[] q4 = {R.mipmap.soiled, R.mipmap.mirror_rusted};

    public Integer[][] selections = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};

    public Boolean[] selected = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_feed_back);

        mainGridAdapter = new MainGridAdapter(getApplicationContext(), mThumbIds, selected);
        fb_grid = (GridView) findViewById(R.id.fb_grid);
        fb_grid.setAdapter(mainGridAdapter);

        fb_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case FLOOR:
                        selected[FLOOR] = !selected[FLOOR];
                        mainGridAdapter.notifyDataSetChanged();
                        break;
                    case TOILET:
                        selected[TOILET] = !selected[TOILET];
                        mainGridAdapter.notifyDataSetChanged();
                        break;
                    case TISSUES:
                        selected[TISSUES] = !selected[TISSUES];
                        mainGridAdapter.notifyDataSetChanged();
                        break;
                    case MIRRORS:
                        selected[MIRRORS] = !selected[MIRRORS];
                        mainGridAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });

        fb_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q1, selections, true, (byte) 0);
                        fb_detail_grid = (GridView) findViewById(R.id.fb_detail_grid);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        fb_detail_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if (position == 0) {
                                    if (selections[0][0] == 1) {
                                        selections[0][0] = 0;
                                        selections[0][1] = 0;
                                    } else {
                                        selections[0][0] = 1;
                                        selections[0][1] = 0;
                                    }
                                } else {
                                    if (selections[0][1] == 1) {
                                        selections[0][0] = 0;
                                        selections[0][1] = 0;
                                    } else {
                                        selections[0][0] = 0;
                                        selections[0][1] = 1;
                                    }
                                }
                                subGridAdapter.notifyDataSetChanged();
                                fb_detail_grid.invalidate();
                                mainGridAdapter.notifyDataSetChanged();
                            }
                        });
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q1, selections, true, (byte) 0);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        subGridAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q2, selections, true, (byte) 1);
                        fb_detail_grid = (GridView) findViewById(R.id.fb_detail_grid);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        fb_detail_grid.setOnItemClickListener(new AdapterView.OnItemClickListener()

                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                if (position == 0) {
                                    if (selections[1][0] == 1) {
                                        selections[1][0] = 0;
                                        selections[1][1] = 0;
                                    } else {
                                        selections[1][0] = 1;
                                        selections[1][1] = 0;
                                    }
                                } else {
                                    if (selections[1][1] == 1) {
                                        selections[1][0] = 0;
                                        selections[1][1] = 0;
                                    } else {
                                        selections[1][0] = 0;
                                        selections[1][1] = 1;
                                    }
                                }
                                //view.findViewById(R.id.white_tick).setVisibility(View.VISIBLE);
                                subGridAdapter.notifyDataSetChanged();
                                mainGridAdapter.notifyDataSetChanged();
                                fb_grid.invalidate();
                                // fb_detail_grid.invalidate();
                            }
                        });
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q2, selections, true, (byte) 1);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        subGridAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q3, selections, true, (byte) 2);
                        fb_detail_grid = (GridView) findViewById(R.id.fb_detail_grid);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        fb_detail_grid.setOnItemClickListener(new AdapterView.OnItemClickListener()

                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                if (position == 0) {
                                    if (selections[2][0] == 1) {
                                        selections[2][0] = 0;
                                        selections[2][1] = 0;
                                    } else {
                                        selections[2][0] = 1;
                                        selections[2][1] = 0;
                                    }
                                } else {
                                    if (selections[2][1] == 1) {
                                        selections[2][0] = 0;
                                        selections[2][1] = 0;
                                    } else {
                                        selections[2][0] = 0;
                                        selections[2][1] = 1;
                                    }
                                }
                                subGridAdapter.notifyDataSetChanged();
                                mainGridAdapter.notifyDataSetChanged();
                                //fb_detail_grid.invalidate();
                            }
                        });
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q3, selections, true, (byte) 2);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        subGridAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        subGridAdapter = new SubGridAdapter(getApplicationContext(), q4, selections, true, (byte) 3);
                        fb_detail_grid = (GridView) findViewById(R.id.fb_detail_grid);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        fb_detail_grid.setOnItemClickListener(new AdapterView.OnItemClickListener()

                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                if (position == 0) {
                                    if (selections[3][0] == 1) {
                                        selections[3][0] = 0;
                                        selections[3][1] = 0;
                                    } else {
                                        selections[3][0] = 1;
                                        selections[3][1] = 0;
                                    }
                                } else {
                                    if (selections[3][1] == 1) {
                                        selections[3][0] = 0;
                                        selections[3][1] = 0;
                                    } else {
                                        selections[3][0] = 0;
                                        selections[3][1] = 1;
                                    }
                                }
                                subGridAdapter.notifyDataSetChanged();
                                fb_detail_grid.invalidate();
                                mainGridAdapter.notifyDataSetChanged();
                            }
                        });
                        subGridAdapter = new

                                SubGridAdapter(getApplicationContext(), q4, selections, true, (byte) 3);
                        fb_detail_grid.setAdapter(subGridAdapter);
                        subGridAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });


    }

    public void Submit(View view) {
        Intent tqintent = new Intent(MoreFeedBackActivity.this, ThankyouActivity.class);
        startActivity(tqintent);
        finish();
    }
}
