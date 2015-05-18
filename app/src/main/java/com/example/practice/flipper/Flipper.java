package com.example.practice.flipper;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewFlipper;

public class Flipper extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);
		ViewFlipper vf= (ViewFlipper) findViewById(R.id.flip);
		vf.setFlipInterval(1000);
		vf.startFlipping();
	}

}
