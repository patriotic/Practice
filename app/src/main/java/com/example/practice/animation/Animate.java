package com.example.practice.animation;

import java.util.Random;

import com.example.practice.R;
import com.example.practice.R.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class Animate extends View{

	private Bitmap ball;
	private int changeY,changeX,countX;
	private Typeface font;
	
	public Animate(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		changeY=0;
		countX=0;
		font = Typeface.createFromAsset(context.getAssets(), "GIDDYUPSTD.OTF");
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.CYAN);
		
		Paint textPaint = new Paint();
		textPaint.setColor(Color.LTGRAY);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(200);
		textPaint.setTypeface(font);
		canvas.drawText("S-BALL", canvas.getWidth()/2, 200, textPaint);
		
		changeX=(canvas.getWidth()/2)-200+countX;
		canvas.drawBitmap(ball,changeX ,changeY , null);
		
		Rect myRect= new Rect();
		myRect.set(0, canvas.getHeight()-200, canvas.getWidth(), canvas.getHeight());
		
		Paint myPaint = new Paint();
		myPaint.setColor(Color.rgb(46, 132, 8));
		
		canvas.drawRect(myRect, myPaint);
		if(changeY<canvas.getHeight()-300){
			changeY+=10;
			Random rnd = new Random();
			countX+=rnd.nextInt(3);
			invalidate();	
		}
		
		
	}
	
	
}
