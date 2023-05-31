package com.example.practicalwork8;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        ImageView imgView = findViewById(R.id.troglodyte);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgView.getDrawable();
        animationDrawable.start();

        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imgView, "scaleX", 1f, 1.5f);
        scaleXAnimator.setDuration(100);
        scaleXAnimator.setRepeatCount(ValueAnimator.INFINITE);
        scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imgView, "scaleY", 1f, 1.5f);
        scaleYAnimator.setDuration(100);
        scaleYAnimator.setRepeatCount(ValueAnimator.INFINITE);
        scaleYAnimator.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(imgView, "rotation", 0f, 360f);
        rotationAnimator.setDuration(1000);
        rotationAnimator.setRepeatCount(ValueAnimator.INFINITE);

        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imgView, "alpha", 1f, 0f);
        alphaAnimator.setDuration(1000);
        alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);
        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofArgb(imgView, "backgroundColor", 0xFFFF0000, 0xFF0000FF);
        backgroundColorAnimator.setDuration(500);
        backgroundColorAnimator.setRepeatCount(ValueAnimator.INFINITE);
        backgroundColorAnimator.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator pulseAnimator = ObjectAnimator.ofFloat(imgView, "pulse", 0f, 1f);
        pulseAnimator.setDuration(100);
        pulseAnimator.setRepeatCount(ValueAnimator.INFINITE);
        pulseAnimator.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator, rotationAnimator, alphaAnimator, backgroundColorAnimator, pulseAnimator);

        animatorSet.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}