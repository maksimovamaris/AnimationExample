package com.example.animationexample;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ViewAnimationActivity extends AppCompatActivity {
    private ImageView mImage;
    private Animation animation = null;
    private Button start_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_anim);
        mImage = findViewById(R.id.view_image);
        mImage.setImageResource(R.drawable.ball);
        start_button = findViewById(R.id.view_start);
        animation = AnimationUtils.loadAnimation(this, R.anim.view_combination);
        start_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mImage.startAnimation(animation);

            }
        });

    }
}