package com.example.animationexample;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ObjectAnimatorActivity extends AppCompatActivity {
    private ObjectAnimator translateXAnimator;
    private ObjectAnimator translateYAnimator;
    private ObjectAnimator rotateAnimator;
    private Handler mHandler;
    private ImageView mImage;
    private  DisplayMetrics displayMetrics;
    private int mDuration ;
@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.object_anim);
    mDuration=4000;
    mHandler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mImage=findViewById(R.id.object_image);
            move(mImage);
        }

    };
    new Timer().schedule(new ExeTimerTask(), 0, mDuration);
}
private void move(ImageView img)
{
    displayMetrics=getResources().getDisplayMetrics();
    int angle = 500 + (int) (Math.random() * 100);
    int movex = (new Random().nextInt(displayMetrics.widthPixels)-40)*10;
    int movey= (displayMetrics.heightPixels + 150 )* 10;
    translateXAnimator=ObjectAnimator.ofFloat(img,"translationX",0,movex);
    translateYAnimator=ObjectAnimator.ofFloat(img,"translationY",0,movey);
    rotateAnimator=ObjectAnimator.ofFloat(img,"rotation",0,angle);
    AnimatorSet animatorSet= new AnimatorSet();
    animatorSet.play(translateXAnimator).with(translateYAnimator).with(rotateAnimator);
    animatorSet.setDuration(mDuration);
    animatorSet.start();
}

    private class ExeTimerTask extends TimerTask
    {
        @Override
        public void run()
        {
            mHandler.sendEmptyMessage(1);
        }
    }

}







