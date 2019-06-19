package com.krishna.restroomfeedback.Activity;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.krishna.restroomfeedback.R;

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final LinearLayout linearLayout = new LinearLayout(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                linearLayout.setAnimation(new Animation() {
                    @Override
                    protected void applyTransformation(float interpolatedTime, Transformation t) {
                        super.applyTransformation(interpolatedTime, t);
                        linearLayout.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
                    }
                });
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
