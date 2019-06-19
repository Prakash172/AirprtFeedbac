package com.krishna.restroomfeedback.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.krishna.restroomfeedback.R;
import com.shashank.sony.fancytoastlib.FancyToast;

public class HomeActivity extends Activity {
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void OpenFBScreen(View view) {

        Intent intent = new Intent(HomeActivity.this, FeedbackActivity.class);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        FancyToast.makeText(this, "Please click BACK again to exit", FancyToast.INFO, FancyToast.WARNING, false).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 3000);
    }
}
