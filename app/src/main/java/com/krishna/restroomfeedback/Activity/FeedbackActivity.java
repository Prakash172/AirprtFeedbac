package com.krishna.restroomfeedback.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.krishna.restroomfeedback.Adapter.MainFBGridAdapter;
import com.krishna.restroomfeedback.Database.MyDatabase;
import com.krishna.restroomfeedback.R;

public class FeedbackActivity extends Activity {
    String[] fb_types;
    int[] fb_images = {R.mipmap.excellent, R.mipmap.good, R.mipmap.average, R.mipmap.poor, R.mipmap.very_poor};
    MainFBGridAdapter mainFBGridAdapter;
    GridView mainFBGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        fb_types = new String[5];
        fb_types = getApplicationContext().getResources().getStringArray(R.array.fb_types);

        mainFBGrid = (GridView) findViewById(R.id.main_fb_grid);
        mainFBGridAdapter = new MainFBGridAdapter(getApplicationContext(), fb_types, fb_images);
        mainFBGrid.setAdapter(mainFBGridAdapter);

        mainFBGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyDatabase database = new MyDatabase(getApplicationContext());
                database.createRecords(position+1);
                Toast.makeText(getApplicationContext(),"Data inserted successfully",Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                    case 1:
                        Intent tqintent = new Intent(FeedbackActivity.this, ThankyouActivity.class);
                        startActivity(tqintent);
                        break;
                    case 2:
                    case 3:
                    case 4:
                        Intent morefbIntent = new Intent(FeedbackActivity.this, MoreFeedBackActivity.class);
                        startActivity(morefbIntent);
                        break;

                }
            }
        });

    }


}
