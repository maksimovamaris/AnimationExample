package com.example.animationexample;

import android.animation.ValueAnimator;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


import android.util.DisplayMetrics;

import android.view.animation.AccelerateInterpolator;

import android.widget.AbsoluteLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ValueAnimatorActivity extends AppCompatActivity
{
    private ImageView mImage;
    private Handler mHandler;
    private  DisplayMetrics displayMetrics;
    private AbsoluteLayout absoluteLayout;//нужен, чтобы поместить изображение за границы экрана
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_anim);
        absoluteLayout=findViewById(R.id.value_layout);


        mHandler=new Handler()
        {
            @Override
        public void handleMessage(Message msg)
            {
            super.handleMessage(msg);
            mImage = findViewById(R.id.value_image);
            displayMetrics = getResources().getDisplayMetrics();
            move(mImage);
        }
        };
        new Timer().schedule(new ExeTimerTask(), 0, 5000);
    }

private void move(final ImageView view)
{
    ValueAnimator animator = ValueAnimator.ofFloat(0, 10);
    int mDuration = 5000;
    animator.setDuration(mDuration);
    animator.setInterpolator(new AccelerateInterpolator());
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

        int angle = 500 + (int) (Math.random() * 101);
        int movex = new Random().nextInt(displayMetrics.widthPixels);

        @Override
        public void onAnimationUpdate(ValueAnimator animation)
        {
            float value = ((Float) (animation.getAnimatedValue()))
                    .floatValue();
            view.setRotation(angle * value);
            view.setTranslationX((movex - 40) * value);
            view.setTranslationY((absoluteLayout.getHeight() + 150 )* value);
        }
    });
    animator.start();
}

    private class ExeTimerTask extends TimerTask
    {
        @Override
        public void run()
        {
            mHandler.sendEmptyMessage(1); //заглушка
        }
    }

    }

