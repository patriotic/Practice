package com.example.practice.animationsurface;

import com.example.practice.R;
import com.example.practice.R.drawable;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class AnimationSurface extends Activity implements OnTouchListener {

	AnimateSurface ans;
	float x, y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ans = new AnimateSurface(this);
		ans.setOnTouchListener(this);
		setContentView(ans);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ans.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ans.resume();
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub

		x = event.getX();
		y = event.getY();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public class AnimateSurface extends SurfaceView implements Runnable {

		private SurfaceHolder holder;
		private Thread thread;
		private Boolean isRunning;

		private Bitmap ball;
		private int changeY, changeX, countX;
		private Typeface font;

		public AnimateSurface(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			holder = getHolder();

			ball = BitmapFactory
					.decodeResource(getResources(), R.drawable.ball);
			changeY = 0;
			countX = 0;
			font = Typeface.createFromAsset(context.getAssets(),
					"GIDDYUPSTD.OTF");

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isRunning) {
				if (!holder.getSurface().isValid())
					continue;

				Canvas canvas = holder.lockCanvas();

				canvas.drawColor(Color.CYAN);

				Paint textPaint = new Paint();
				textPaint.setColor(Color.LTGRAY);
				textPaint.setTextAlign(Align.CENTER);
				textPaint.setTextSize(200);
				textPaint.setTypeface(font);
				canvas.drawText("S-BALL", canvas.getWidth() / 2, 200, textPaint);

				// changeX = (canvas.getWidth() / 2) - 200 + countX;
				// canvas.drawBitmap(ball, changeX, changeY, null);

				Rect myRect = new Rect();
				myRect.set(0, canvas.getHeight() - 200, canvas.getWidth(),
						canvas.getHeight());

				Paint myPaint = new Paint();
				myPaint.setColor(Color.rgb(46, 132, 8));

				canvas.drawRect(myRect, myPaint);

				if (x != 0 && y != 0) {
					canvas.drawBitmap(ball, x - (ball.getWidth() / 2), y
							- (ball.getHeight() / 2), null);
				}
				// if (changeY < canvas.getHeight() - 300) {
				// changeY += 10;
				// Random rnd = new Random();
				// countX += rnd.nextInt(3);
				// // invalidate();
				// } else {
				// isRunning= false;
				// }

				holder.unlockCanvasAndPost(canvas);
			}
		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			thread = null;
		}

		public void resume() {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}
}
