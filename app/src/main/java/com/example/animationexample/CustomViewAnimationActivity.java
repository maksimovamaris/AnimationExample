package com.example.animationexample;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewAnimationActivity extends  AppCompatActivity {
private CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customview_anim);
        customView=findViewById(R.id.custom_view);
        animateView(customView);

    }
    private void animateView(CustomView view) {
        view.setAnimation(AnimationUtils.loadAnimation(view.getContext(),R.anim.view_combination));
    }

}
