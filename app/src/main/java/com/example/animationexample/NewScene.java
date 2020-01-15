package com.example.animationexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NewScene extends AppCompatActivity {
    private Button btn_back;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_2);
        image=findViewById(R.id.element_trasition_image);
btn_back=findViewById(R.id.scene_back);
btn_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(NewScene.this,ElemTransitionAnimationActivity.class);
      startActivity(intent);
    }
});
    }
}
