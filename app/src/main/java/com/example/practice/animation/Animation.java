package com.example.practice.animation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class Animation extends Activity{

	Animate an;
	WakeLock wl;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Something");
		
		
		super.onCreate(savedInstanceState);
		an= new Animate(this);
		setContentView(an);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		wl.acquire();
	}
	

}
