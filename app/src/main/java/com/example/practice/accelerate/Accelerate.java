package com.example.practice.accelerate;

import com.example.practice.R;
import com.example.practice.R.drawable;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate extends Activity implements SensorEventListener {

	private Boolean isRunning = false;
	private float x, y, sensorX, sensorY;
	SensorManager sm;
	Thread thread = null;
	AnimateSurface ans;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ans = new AnimateSurface(this);
		setContentView(ans);

		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);

		}
		x = y = sensorX = sensorY = 0;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		
		sensorX = arg0.values[0];
		sensorY = arg0.values[1];

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub

		super.onPause();
		sm.unregisterListener(this);
		ans.pause();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		ans.resume();

	}

	public class AnimateSurface extends SurfaceView implements Runnable {

		private SurfaceHolder holder;

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
				canvas.drawBitmap(ball, (canvas.getWidth() / 2) + sensorX * 20,
						(canvas.getHeight() / 2) + sensorY * 20, null);

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