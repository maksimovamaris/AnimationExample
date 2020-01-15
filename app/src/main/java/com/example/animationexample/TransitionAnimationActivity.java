package com.example.animationexample;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TransitionAnimationActivity extends AppCompatActivity {
    private Scene anotherScene;
    private ViewGroup sceneRoot;
    private Button forwardButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_anim);
// Create the scene root for the scenes in this app
        sceneRoot = (ViewGroup) findViewById(R.id.scene_root);
// Create the scenes
        anotherScene =
                Scene.getSceneForLayout(sceneRoot, R.layout.scene_1, this);
        forwardButton=findViewById(R.id.scene_forward);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generateTransition(anotherScene);
            }
        });



    }
private void generateTransition(Scene endingScene)
{
    Transition fadeTransition = new Fade();
    fadeTransition.setDuration(3000);
    TransitionManager.go(endingScene, fadeTransition);

}
}
