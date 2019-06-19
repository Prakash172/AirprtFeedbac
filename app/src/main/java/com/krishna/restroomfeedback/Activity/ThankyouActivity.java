package com.krishna.restroomfeedback.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.krishna.restroomfeedback.Database.MyDatabase;
import com.krishna.restroomfeedback.R;

import static android.content.ContentValues.TAG;

public class ThankyouActivity extends Activity {
    private static int THANKYOU_TIME_OUT = 10000;
    private static final String TAG = "ThankyouActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(ThankyouActivity.this, HomeActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, THANKYOU_TIME_OUT);*/
    }

    public void GoToHome(View view) {
        Intent i = new Intent(ThankyouActivity.this, GraphActivity.class);
        startActivity(i);
        finish();
        // close this activit
    }
}
