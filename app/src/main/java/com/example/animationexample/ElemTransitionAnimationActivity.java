package com.example.animationexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityOptionsCompat;

public class ElemTransitionAnimationActivity extends AppCompatActivity {
    private Button btn_forward;

    private ImageView elem_transit_img;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.element_transition_anim);
        btn_forward=findViewById(R.id.scene_forward_element);
        elem_transit_img=findViewById(R.id.element_trasition_image);
        btn_forward.setOnClickListener(this::animateIntent);
    }
    public void animateIntent(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, NewScene.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.transition_string);

        // Define the view that the animation will start from

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                       elem_transit_img,   // Starting view
                        transitionName    // The String
                );
        startActivity(intent,options.toBundle());

    }
}
