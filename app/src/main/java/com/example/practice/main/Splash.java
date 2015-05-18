package com.example.practice.main;

import com.example.practice.R;
import com.example.practice.R.layout;
import com.example.practice.R.raw;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {

	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(this, R.raw.splash_sound);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		Boolean music = getPrefs.getBoolean("check", true);
		
		if(music == true){
			ourSong.start();
		}
		
		Thread timer = new Thread(){

			@Override
			public void run() {
				try{
					
					sleep(5000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent i = new Intent("com.example.practice.main.Menu");
					startActivity(i);
				}
			}	
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
