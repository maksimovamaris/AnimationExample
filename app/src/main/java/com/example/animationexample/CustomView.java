package com.example.animationexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private Paint BATTERY_PAINT=new Paint((Paint.ANTI_ALIAS_FLAG));
    private DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap battery= BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        canvas.drawBitmap(battery,displayMetrics.widthPixels/3,displayMetrics.heightPixels/3,BATTERY_PAINT);
    }

}
