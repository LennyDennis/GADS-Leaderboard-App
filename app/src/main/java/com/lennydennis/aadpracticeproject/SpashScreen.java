package com.lennydennis.aadpracticeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.lennydennis.aadpracticeproject.databinding.ActivitySpashScreenBinding;

public class SpashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActivitySpashScreenBinding splashScreenBinding = ActivitySpashScreenBinding.inflate(getLayoutInflater());
        setContentView(splashScreenBinding.getRoot());

        Animation topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        splashScreenBinding.gadsLogo.setAnimation(topAnimation);

    }
}