package com.example.flyingfishquest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class FlyingFishView extends View {

    private Bitmap fish[]  = new Bitmap[2];
    private int fishX =10;
    private int fishY ;
    private int fishSpeed;
    private int canvasWidth, canvasHeight;
    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life[] = new Bitmap[2];



    public FlyingFishView(Context context) {
        super(context);
        fish[0] = BitmapFactory.decodeResource(getResources(),R.drawable.fish1);
        fish[1] = BitmapFactory.decodeResource(getResources(),R.drawable.fish2);

        backgroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);
        life[0] = BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        int minFishY = fish[0].getHeight();
        int maxFishY = canvasHeight - fish[0].getHeight()*3;
        fishY = fishY * fishSpeed;

        if(fishY < minFishY) {
            fishY = minFishY;
        }

        if(fishY > maxFishY) {
            fishY = maxFishY;
        }


        canvas.drawBitmap(backgroundImage, 0 ,0, null);

        canvas.drawText("score",20,60,scorePaint);
        canvas.drawBitmap(life[0], 580 ,10, null);
        canvas.drawBitmap(life[0], 680 ,10, null);
        canvas.drawBitmap(life[0], 780,10, null);

    }
}
