package com.example.animationexample;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FrameAnimationActivity extends AppCompatActivity
{
    private static final int DURATION = 250 ;
    private ImageView drawable_image;
    private Button drawable_start;
    private Button drawable_stop;
    private BitmapDrawable frame1;
    private BitmapDrawable frame2;
    private BitmapDrawable frame3;
    private AnimationDrawable mAnimationDrawable;
    private void startFrameAnimation()
    {
        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.setOneShot(false);
        mAnimationDrawable.addFrame(frame1, DURATION);
        mAnimationDrawable.addFrame(frame2, DURATION);
        mAnimationDrawable.addFrame(frame3, DURATION);
        drawable_image.setBackground(mAnimationDrawable);

        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.setVisible(true, true);
            mAnimationDrawable.start();
        }
    }
    private void stopFrameAnimation(){
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
            mAnimationDrawable.setVisible(false, false);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_anim);
        frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic1);
        frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic2);
        frame3= (BitmapDrawable)getResources().getDrawable(R.drawable.pic3);
        drawable_image=findViewById(R.id.drawable_image);
        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.addFrame(frame1, DURATION);
        drawable_image.setBackground(mAnimationDrawable);
        drawable_start=findViewById(R.id.drawable_start);
        drawable_stop=findViewById(R.id.drawable_stop);
        drawable_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFrameAnimation();
            }
        });
        drawable_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopFrameAnimation();
            }
        });
    }


}
