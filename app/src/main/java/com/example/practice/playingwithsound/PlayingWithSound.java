package com.example.practice.playingwithsound;

import com.example.practice.R;
import com.example.practice.R.raw;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class PlayingWithSound extends Activity implements OnClickListener, OnLongClickListener {

	SoundPool sp;
	MediaPlayer mp;
	int shotgun =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v =new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		sp= new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		shotgun =sp.load(this, R.raw.shotgun, 0);
		mp = MediaPlayer.create(this, R.raw.background);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(shotgun !=0)
			sp.play(shotgun, 1, 1, 0, 0 , 1);
	}
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		mp.start();
		return false;
	}

}
