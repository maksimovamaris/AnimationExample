package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button frame_button;
private Button view_button;
private Button value_button;
private Button object_button;
private Button custom_button;
private Button transition_button;
private Button elem_transit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame_button=findViewById(R.id.button_frame);
        frame_button.setOnClickListener(this::onFrameClick);
        view_button=findViewById(R.id.button_view);
        view_button.setOnClickListener(this::onViewClick);
        value_button=findViewById(R.id.button_value);
        value_button.setOnClickListener(this::onValueClick);
        object_button=findViewById(R.id.button_object);
        object_button.setOnClickListener(this::onObjectClick);
        custom_button=findViewById(R.id.button_customview);
        custom_button.setOnClickListener(this::onCustomClick);
        transition_button=findViewById(R.id.button_transition);
        transition_button.setOnClickListener(this::onTransitionClick);
        elem_transit_btn=findViewById(R.id.button_elem_transition);
        elem_transit_btn.setOnClickListener(this::onElemTransitionClick);
    }
    private void onFrameClick(View view) {
        Intent intent = new Intent(this, FrameAnimationActivity.class);
        startActivity(intent);
    }
    private void onViewClick(View view) {
        Intent intent = new Intent(this, ViewAnimationActivity.class);
        startActivity(intent);
    }
    private void onValueClick(View view) {
        Intent intent = new Intent(this, ValueAnimatorActivity.class);
        startActivity(intent);
    }

    private void onObjectClick(View view) {
        Intent intent = new Intent(this, ObjectAnimatorActivity.class);
        startActivity(intent);
    }

    private void onCustomClick(View view)
    {
        Intent intent = new Intent(this, CustomViewAnimationActivity.class);
        startActivity(intent);
    }
    private void onTransitionClick(View view)
    {
        Intent intent = new Intent(this, TransitionAnimationActivity.class);
        startActivity(intent);
    }
    private void onElemTransitionClick(View view)
    {
        Intent intent = new Intent(this, ElemTransitionAnimationActivity.class);
        startActivity(intent);
    }
}
