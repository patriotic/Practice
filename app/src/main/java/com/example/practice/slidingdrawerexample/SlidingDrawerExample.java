package com.example.practice.slidingdrawerexample;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;
import com.example.practice.R.raw;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class SlidingDrawerExample extends Activity implements OnDrawerOpenListener, OnDrawerCloseListener, OnCheckedChangeListener {

	MediaPlayer mp;
	@SuppressWarnings("deprecation")
	SlidingDrawer sd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding_drawer);
		
		sd = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
		sd.setOnDrawerOpenListener(this);
		sd.setOnDrawerCloseListener(this);
		
		CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
		cb.setOnCheckedChangeListener(this);
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		mp= MediaPlayer.create(this, R.raw.background);
		mp.start();
	}

	@Override
	public void onDrawerClosed() {
		// TODO Auto-generated method stub
		mp.stop();
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if(arg0.isChecked()){
			sd.lock();
		}else{
			sd.unlock();
		}
	}
	

}
