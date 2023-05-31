package com.example.practicalwork8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tweenButton = findViewById(R.id.button);
        Button frameButton = findViewById(R.id.button2);

        tweenButton.setEnabled(false);
        frameButton.setEnabled(false);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        tweenButton.startAnimation(fadeInAnimation);
        fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        frameButton.startAnimation(fadeInAnimation);

        tweenButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), TweenActivity.class);
            view.getContext().startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        frameButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), FrameActivity.class);
            view.getContext().startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tweenButton.setEnabled(true);
                frameButton.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}